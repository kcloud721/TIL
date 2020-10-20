package com.example.p533;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView listView;
    LinearLayout container;
    ArrayList<Boxs> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView = findViewById(R.id.listView);
        container = findViewById(R.id.container);
        list = new ArrayList<>();
        getData();
    }

    private void getData() {
        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20200101";
        ItemAsync itemAsync = new ItemAsync();
        itemAsync.execute(url);
    }

    class ItemAsync extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(SecondActivity.this);
            progressDialog.setTitle("GET DATA!!");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0].toString();
            String result = HttpConnect.getString(url);
            return result;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            JSONArray ja = null;
            JSONObject jObject = null;
            try {
                // 가장 큰 JSONObject를 가져옵니다.
                jObject = new JSONObject(s);

                // 첫번째 JSONObject를 가져와서 key-value를 읽습니다.
                JSONObject object1 = jObject.getJSONObject("boxOfficeResult");
                System.out.println(object1.toString());

                // 배열을 가져옵니다.
                JSONArray jArray = object1.getJSONArray("dailyBoxOfficeList");

                // 배열의 모든 아이템을 출력합니다.
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject obj = jArray.getJSONObject(i);
                    String title = obj.getString("movieNm");
                    int rank = obj.getInt("rank");
                    System.out.println("title(" + rank + "): " + title);
                    Boxs boxs = new Boxs(rank, title);
                    list.add(boxs);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            ItemAdapter itemAdapter = new ItemAdapter();
            listView.setAdapter(itemAdapter);
        }
    }

    class ItemAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = null;
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.boxs, container, true);

            TextView mv_rank = itemView.findViewById(R.id.list_rank);
            TextView mv_movieNm = itemView.findViewById(R.id.list_name);

            mv_movieNm.setOnClickListener((View.OnClickListener) this);

            mv_movieNm.setText(list.get(position).getMovieNm());
            mv_rank.setText(list.get(position).getRank()+"");
            return itemView;
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.list_name:
                System.out.println("AAAASDFAASDFASDFASD");
                break;
        }

    }
}