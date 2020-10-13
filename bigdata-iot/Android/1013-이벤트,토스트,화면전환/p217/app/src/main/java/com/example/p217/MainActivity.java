package com.example.p217;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(20); // 단계 설정
    }

    public void clickb1(View v){
        Toast t = Toast.makeText(this,"Toast1 ...", Toast.LENGTH_SHORT);
        //t.setGravity(50,50,100);
        t.setGravity(Gravity.CENTER,0,0); // Gravity가 시작점
        t.show();
    }
    public void clickb2(View v){    // Toast 커스텀
        LayoutInflater inflater = getLayoutInflater();   // 먼저 화면을 만듦
        View view = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_custom));
        TextView tv = view.findViewById(R.id.textView);
        tv.setText("INPUT TEXT");

        Toast t = new Toast(this);  // 만든 화면을 표시
        t.setGravity(Gravity.CENTER,0,0);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(view);
        t.show();
    }
    public void clickb3(View v){
        Snackbar.make(v, "Snack Bar Test", Snackbar.LENGTH_LONG).show();
    }


    public void clickb4(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("My Dialog");
        builder.setMessage("Exit Now");
        builder.setIcon(R.drawable.img);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed(); -- 이게 있으면 바로 종료되네
        LayoutInflater inflater = getLayoutInflater();   // 먼저 화면을 만듦
        View view = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_custom));

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("My Dialog");
        builder.setMessage("Exit Now");
        builder.setView(view);
        builder.setIcon(R.drawable.img);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void btprogress(View v){
        ProgressDialog progressDialog = null;
        if(v.getId() == R.id.button5){
            int pdata = progressBar.getProgress();
            if(pdata < 20){
                progressBar.setProgress(pdata + 1);
            } else{
                Toast.makeText(this, "Max Value", Toast.LENGTH_SHORT);
            }
        } else if(v.getId() == R.id.button6){
            int pdata = progressBar.getProgress();
            progressBar.setProgress(pdata - 1);
        } else if(v.getId() == R.id.button7){   // 프로그레스바 표시
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setTitle("Downloading...");
            progressDialog.setCancelable(false);    // 팝업 바깥쪽 눌러도 없어지지 않음 > dismiss 걸려야 종료
            progressDialog.show();
        } else if(v.getId() == R.id.button8){   // 프로그레스바 종료
            progressDialog.dismiss();
        }
    }

    public void customToast(){
        LayoutInflater inflater = getLayoutInflater();   // 먼저 화면을 만듦
        View view = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_custom));
        TextView tv = view.findViewById(R.id.textView);
        tv.setText("INPUT TEXT");

        Toast t = new Toast(this);
        t.setGravity(Gravity.CENTER,0,0);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(view);
        t.show();
    }
}