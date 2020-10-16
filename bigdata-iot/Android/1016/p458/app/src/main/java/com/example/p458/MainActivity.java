package com.example.p458;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());      // 웹뷰 초기화

        WebSettings webSettings = webView.getSettings();    // 옵션 추가
        webSettings.setJavaScriptEnabled(true);             // 자바스크립트 허용
    }

    public void ckbt(View v){
        if(v.getId() == R.id.button){
            webView.loadUrl("http://naver.com");        // 화면에 웹뷰 그리기

        } else if(v.getId() == R.id.button2){
            webView.loadUrl("http://daum.net");

        } else if(v.getId() == R.id.button3){
            webView.loadUrl("http://192.168.1.22/android");

        }
    }
}