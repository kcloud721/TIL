| 과목                            | 프로젝트명 |
| ------------------------------- | ---------- |
| 인텐트 ACTION_CALL 등           | p251       |
| 권한요청 Permission             | p251       |
| 화면 전환 : 프래그먼트 Fragment | p287       |
| 액션바                          | p312       |
| 상,하단 탭 만들기               | p323, p331 |
| 워크샵                          | p351       |



## 인텐트의 세컨드 액티비티와 프래그먼트의 차이점?

[읽어보기](https://ksb0511.tistory.com/entry/Fragment%EC%97%90%EC%84%9C-Activity%EB%A1%9C-%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98)

# 안드로이드 패키지 

1. 안드로이드 스튜디오
2. Widget, Layout, Event
3. Android 4 Component
   - Activity : Base, UI
   - Service : Background process
   - Broadcast Receiver : Broadcast 내용을 받는다. 
   - Content Provider

# Intent: Second Activity

project : p251

Main Activity에서 Second로 이동

```java
public void ckbt(View v){
    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
    startActivity(intent);
}
```

# 권한 요청

```bash
Caused by: java.lang.SecurityException: Permission Denial:
...
requires android.permission.CALL_PHONE
```

전화걸 수 있는 권한이 없으므로 

1. AndroidManifest.xml 에서 권한 정의

```xml
<uses-permission android:name="android.permission.CALL_PHONE" />
```

2. MainActivity.java 에서 권한 묻는 작업

3. ```java
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       ...
       String [] permissions = {Manifest.permission.CALL_PHONE};
       ActivityCompat.requestPermissions(this, permissions, 101);
   }
   ```

> 화면 회전시 Destroy 후 다시 Create

# 프레그먼트

project : p287

# 액션바 사용하기

p.312

# 상단,하단 탭 만들기

project: p323, p331

## fragment에서 토스트 메시지 띄우기

토스트 메시지는 MainActivity 에서 띄워지는 것이기 때문에 MainActivity 정보를 fragment.java에 전달하여 토스트 함수 인자에 넣어야 함

1. MainActivity.java : fragment 에 Main this 전달

   ```java
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
   
       fragment1 = new Fragment1(this);    // fragment에 현재 메인액티비티 전달
   ```

2. Fragment1. java

   ```java
   public class Fragment1 extends Fragment {
       Button button;
       MainActivity m;
   
       // MainActivity 에서 보낸 this 받아옴
       // fragment 에서 Toast 띄우우기 위해.. 메인액티비티에 띄워야 하므로 정보 받아와 토스트 던질때 m 입력
       public Fragment1(MainActivity m) {
           this.m = m;
       }
   
       public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
           ViewGroup viewGroup = null;
           viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_1,container,false);
           button = viewGroup.findViewById(R.id.button);
   
           button.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v) {
                   Toast.makeText(m, "aaa", Toast.LENGTH_SHORT).show();
               }
           });
           return viewGroup;
       }
   }
   ```

# Workshop

project : p351

1. 상단 ActionBar > Setting 메뉴 추가하고 클릭 시 setting 화면 이동
2. 메뉴1에서 버튼 클릭 : 토스트
3. 메뉴2에서 버튼 클릭 : 프로그레스바 동그라미
4. 메뉴3에서 버튼 클릭 : alert dialog

