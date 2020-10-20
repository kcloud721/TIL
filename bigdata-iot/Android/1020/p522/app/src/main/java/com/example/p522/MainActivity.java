package com.example.p522;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("login", MODE_PRIVATE);
        String status = sp.getString("status", "");
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }

    // 정보 저장
    public void ck(View v){
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("status", "ok");
        edit.commit();
    }

    // 저장된 정보 삭제
    public void ck2(View v){
        SharedPreferences.Editor edit = sp.edit();
        edit.remove("status");
        edit.commit();
    }
}