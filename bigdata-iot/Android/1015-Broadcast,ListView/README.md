| 과목                             | 프로젝트 |
| -------------------------------- | -------- |
| 권한요청, 기기상태, 브로드캐스트 | p362     |
| listView 로 목록 생성 및 삭제    | p        |

# 브로드캐스트 수신자 이해하기

project : p362

권한부여가 선행되어야 브로드캐스트 가능

## 권한부여

AndroidManifest.xml 에서 퍼미션 추가

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.p362">
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.RECEIVE_SMS" />
    <uses-permission android:name="android.permission.SEND_SMS" />
    <uses-permission android:name="android.permission.CALL_PHONE" />
    <application 
                 ...
```

## 브로드캐스트

권한 필요

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        String permissions[] = {    // 앱 시작시 권한 요청
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS,
                Manifest.permission.RECEIVE_SMS
        };
        ActivityCompat.requestPermissions(this, permissions, 101);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
      ...
```

```java
broadcastReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        String cmd = intent.getAction();
        ConnectivityManager cm = null;
        NetworkInfo mobile = null;
        NetworkInfo wifi = null;

        // 연결 매니저
        if(cmd.equals("android.net.conn.CONNECTIVITY_CHANGE")){
            cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if(mobile != null && mobile.isConnected()){

            }else if(wifi != null && wifi.isConnected()){ //wifi 연결상태에 따른 이미지 표시
                imageView.setImageResource(R.drawable.wifi);
            }else{
                imageView.setImageResource(R.drawable.nwifi);

            }
        } else if(cmd.equals("android.provider.Telephony.SMS_RECEIVED")){
            Toast.makeText(context, "SMS_RECEIVED", Toast.LENGTH_SHORT).show();
            Bundle bundle = intent.getExtras();
            Object [] obj = (Object [])bundle.get("pdus");
            SmsMessage [] messages = new SmsMessage[obj.length];
            for(int i=0; i<obj.length; i++){
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[])obj[i], format);
            }
            String msg = "";
            if(messages != null && messages.length > 0){
                msg += messages[0].getOriginatingAddress() ;
                msg += messages[0].getMessageBody().toLowerCase();
                msg += new Date(messages[0].getTimestampMillis()).toString();
                textView.setText(msg);
            }
        }
    }
};
```

# listView

activity_main.xml 에서 legacy > ListView를 추가

초기화 

```java
public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        datas = new ArrayList<>();
    }
```



getData() 함수 선언

```java
public void getData(){
    datas = new ArrayList<>();
    for(int i=0; i<20; i++){
        datas.add("Item:"+i);
    }
    setList(datas);
}
```



setList()

```java
public void setList(final ArrayList<String> datas){
    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            datas
    );
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
            Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
          // 다이얼로그 누르면 리스트 삭제하도록
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("HI");
            builder.setMessage("Are you deleted this Item: " + datas.get(position));
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    datas.remove(position);
                    adapter.notifyDataSetChanged(); // 지우고 다시 화면을 그리기 위함
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
        }
    });
}
```