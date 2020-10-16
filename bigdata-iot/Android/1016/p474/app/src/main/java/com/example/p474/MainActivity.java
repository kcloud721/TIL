package com.example.p474;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar, progressBar2;
    TextView textView, textView2;
    MyHandler myHandler;
    MyHandler2 myHandler2;
    Button button, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar.setMax(50);
        progressBar2.setMax(50);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        myHandler = new MyHandler();
        myHandler2 = new MyHandler2();
    }

    public void chbt(View v) throws InterruptedException {
        if(v.getId() == R.id.button){
            MyThread t = new MyThread();
            t.start();  // Sub Thread 실행
            button.setEnabled(false);   // 스레드 실행되는 동안 중복 실행 방지 .. t.start 끝나지 않아도 아래 행으로 넘어가기 땜에 실행 가능
        }else if(v.getId() == R.id.button2){
            Thread t = new Thread(new MyThread2()); //implements 받은 객체는 Thread 안에 만들어야
            t.start();
            button2.setEnabled(false);
        }else if(v.getId() == R.id.button3){
            progress();
        }
    }

    public void progress(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("progress");
        dialog.setMessage("5 sec");
        final Handler handler = new Handler();
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressDialog.setCancelable(true);
                progressDialog.setTitle("Downloading...");
                progressDialog.show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                }, 5000);
            }
        });
        dialog.show();
    }

    // MainThread 와 다른 별도의 Sub Thread 선언
//    Thread t = new Thread(){
    class MyThread extends Thread{  // 위와 달리 여러번 눌러도 동작됨.. 각각 클래스를 만들기때문에 가능한듯?
        @Override
        public void run() {
            for(int i=0; i<=50; i++){
                progressBar.setProgress(i);
                textView.setText(i+"");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    button.setEnabled(true);
                }
            });
//            button.setEnabled(true);
            // 이렇게 그냥 넣으면 서브 스레드가 메인 스레드를 변경하려고 해서 오류 남
        }
    };

    // Handler
    class MyHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();
            int data = bundle.getInt("tdata", 0);
            textView.setText("Handler1: " + data);
            progressBar.setProgress(data);
        }
    }
    class MyHandler2 extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle bundle = msg.getData();
            int data = bundle.getInt("tdata", 0);
            textView2.setText("Handler2: " + data);
            progressBar2.setProgress(data);
            // handler는 메인스레드의 영역이기 때문에 66라인처럼 Runnalble 안써도 됨
            if(data == 49){
                button2.setEnabled(true);
            }
        }
    }
    class MyThread2 implements Runnable{
        @Override
        public void run() {
            for(int i=0; i<=50; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = myHandler.obtainMessage();     // 핸들러로부터 메시지 받음
                Message message2 = myHandler2.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putInt("tdata", i);  // 전달 할 값을 번들에 담아
                message.setData(bundle);    // 번들을 메시지에 담아
                message2.setData(bundle);
//                myHandler.sendMessage(message); // 메시지를 핸들러로 보냄
                myHandler2.sendMessage(message2);
            }
        }
    }
}