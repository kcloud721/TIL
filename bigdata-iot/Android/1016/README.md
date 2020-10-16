



| 과목                                | 프로젝트 |
| ----------------------------------- | -------- |
| WebView : 앱 화면에 웹브라우저 넣기 | p458     |
| SeekBar로 화면 밝기 제어            | p464     |
| AsyncTask                           | p489     |



# WebView : 앱 화면에 브라우저 넣기

project : p458

```java
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
```



AndroidManifest.xml인터넷 접속 권한 부여 & 텍스트 URL 허용

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.p458">
    <uses-permission android:name="android.permission.INTERNET" />
    <application
        android:usesCleartextTraffic="true"
```



# 화면 밝기 제어

```java
public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(progress+"");  // ""추가해서 String으로 바꿔줌
                setBtight(progress);
            }
```

```java
public void setBtight(int value){
    WindowManager.LayoutParams params = getWindow().getAttributes();
    params.screenBrightness = (float)value/100;
    getWindow().setAttributes(params);
}
```



# Thread & Handler

## 1. Thread

project : p474

1. Tread & Runnable : java에서 멀티스레드 구현
2. Handler : only 안드로이드
3. AsynchTask : only 안드로이드

모든 Thread 의 문맥은 run() 안에서 실행

```java
public void chbt(View v) throws InterruptedException {
    if(v.getId() == R.id.button){
        t.start();  // Sub Thread 실행 
    }else if(v.getId() == R.id.button2){

    }else if(v.getId() == R.id.button3){

    }
}

// MainThread 와 다른 별도의 Sub Thread 선언
Thread t = new Thread(){
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
    }
};
```



## 2. Handler

핸들러 : 서브 스레드에서 변경되는 상태를 메인스레드에게 알려주는 것

스레드 간 메시지 전달 역할?

```java
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
```



# Async Task

project : p489

| 메서드           | 기능                                        |
| ---------------- | ------------------------------------------- |
| doInBackground   | 새로 만든 스레드에서 백그라운드 ㅈ가업 수행 |
| onProgressUpdate | 백그라운드 작업의 진행상태 표시             |
| onPostExecute    | 백그라운드 작업 후 호출                     |



```java
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
```