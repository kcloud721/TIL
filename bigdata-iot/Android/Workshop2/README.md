# Fragment에서 Button 사용하기

일반적으로 하면 Null Point 에러가 남

```bash
java.lang.IllegalStateException: Could not find method onClick(View) in a parent or ancestor Context for android:onClick attribute defined on view class androidx.appcompat.widget.AppCompatButton with id 'button1'
```

## 해결방법

Fragment onCreateView에서 View를 찾아 매칭

```java
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup = null;
        viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_3, container, false);

        button1 = viewGroup.findViewById(R.id.button1);
        button1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) m.getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100,10));
                }else{
                    vibrator.vibrate(1000);
                }
            }
        });
        return viewGroup;
    }
```



 ㅊㅊ : https://artisticbit.tistory.com/entry/BommonNavigationView-%EC%99%80-Fragment%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%ED%99%94%EB%A9%B4%EC%A0%84%ED%99%98



