package com.example.p200;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

// 터치 이벤트 처리하기
public class MainActivity extends AppCompatActivity {
    TextView textView;
    LinearLayout view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activity_main.xml 에서 생성한 요소의 id 지정
        textView = findViewById(R.id.textView);
        view = findViewById(R.id.view);

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float x = event.getX();
                float y = event.getY();
                if(action == MotionEvent.ACTION_DOWN){
                    print("DOWN: "+ x +", "+ y);
                }else if(action == MotionEvent.ACTION_MOVE){
                    print("MOVE: "+ x +", "+ y);
                } else if (action == MotionEvent.ACTION_UP) {
                    print("UP: "+ x +", "+ y);
                }
                return true;
            }
        }); //onCreate End
    }

    public void print(String str){
        textView.setText(str);
    }

    // BACK 키 눌렀을 때 토스트 메시지 방법 1
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "BACK KEY PRESSED", Toast.LENGTH_SHORT).show();
        }
        return super.onKeyDown(keyCode, event);
    }

    // BACK 키 눌렀을 때 토스트 메시지 방법 2
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "BACK KEY PRESSED", Toast.LENGTH_SHORT).show();
        finish();
    }
}