package com.example.p207;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText et;
    TextView textView;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    // 최초 실행했을 때?
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show("onCreate");
        Log.d("[TEST]","onCreate");
        button = findViewById(R.id.button);
        et = findViewById(R.id.et);
        textView = findViewById(R.id.textView2);
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        /* ---- AndroidManifest.xml 에 android:screenOrientation="landscape"  설정했을 때
                가로모드에는 없는 버튼 비활성시켜야 정상작
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et.getText().toString();
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        */
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("[TEST]","ConfigChanged");

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "LANDSCAPE", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            Log.d("[TEST]","landscape");

        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "PORTRAIT", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
        }
    }

    @Override
    protected void onStart() {  // 앱이 화면에 나타날 때
        super.onStart();
        show("onStart");
        Log.d("[TEST]","onStart");
    }

    @Override
    protected void onStop() {   // 앱 밖으로 나갔을 때.. 요걸 안하면 배터리 소모 많은 앱으로 감지됨
        super.onStop();
        show("onStop");
        Log.d("[TEST]","onStop");
    }

    @Override
    protected void onDestroy() {    // 종료했을 때
        super.onDestroy();
        show("onDestroy");
        Log.d("[TEST]","onDestory");

    }

    public void show(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

}