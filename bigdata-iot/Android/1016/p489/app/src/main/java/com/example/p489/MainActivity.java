package com.example.p489;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button, button2;
    SeekBar seekBar;
    TextView textView;
    ImageView imageView;
    MyAsynch myAsynch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);
        imageView = findViewById(R.id.imageView);
    }

    public void ckbt1(View v){
        myAsynch = new MyAsynch();
        myAsynch.execute(80);   // 인자 전달 가능
    }
    public void ckbt2(View v){

    }

    class MyAsynch extends AsyncTask<Integer, Integer, String>{ // 시작, 중간, 결과
        @Override
        protected String doInBackground(Integer... integers) {
            int a = integers[0].intValue();
            int sum  = 0;
            for(int i=0; i<a; i++){
                sum += i;
                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "result: "+sum;  // onPosetExecute 로 전달
        }

        @Override
        protected void onProgressUpdate(Integer... values) {    // ... 이 있으면 배열로 받음
            int i = values[0].intValue();
            seekBar.setProgress(i);
            if(i < 30){
                imageView.setImageResource(R.drawable.down);
            }else if(i <= 70){
                imageView.setImageResource(R.drawable.mid);

            }else if(i <= 100){
                imageView.setImageResource(R.drawable.up);

            }
        }

        @Override
        protected void onPostExecute(String s) {
            textView.setText(s);
        }

//        @Override
//        protected void onCanceled(String s) {
//            super.onCancelled(s);
//        }
    }
}