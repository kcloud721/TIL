| 과목                                     | 프로젝트명 |
| ---------------------------------------- | ---------- |
| Shared Preferences                       | p522       |
| GPS 위치정보 받아오기 : Location Manager | p667       |
| 구글맵 : 템플릿 활용하여 그리기          | p674       |
| 구글맵 : 빈 화면에서 그리기              | p675       |
| 구글맵 : 마커, 위치제어, 카메라 이동     | p676       |
| Fragment에 구글맵 그리기 (미완성)        | p287       |



# SharedPreferences

project : p522

최초 실행시 토스트에 암것도 안뜸

버튼 눌러서 SharedPreferences로 값 저장하고

종료후 다시 실행하면 토스트 메시지 뜸

▶︎ 데이터를 저장해놓을 수 있다는 거

ex)  로그인 정보

```java
edit.putString("status", "ok");
```

```java
edit.remove("status");
```



# GPS 위치정보 받아오기

project : p667

# 구글맵 표시

## 템플릿 활용

projoect : p674

## Empty에서 그리기

project : p675

1. google Console에 패키지 정보 입력
2. build.gradle에 googleMap API 추가 - sync now
3. androidManifest.xml에 key값 입력

build.gradle

```
implementation 'com.google.android.gms:play-services-maps:17.0.0'
```