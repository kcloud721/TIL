| 과목                                     | 프로젝트명 |
| ---------------------------------------- | ---------- |
| Shared Preferences                       | p522       |
| GPS 위치정보 받아오기 : Location Manager | p667       |
| 구글맵 : 템플릿 활용하여 그리기          | p674       |
| 구글맵 : 빈 화면에서 그리기              | p675       |
| 구글맵 : 마커, 위치제어, 카메라 이동     | p676       |
| Fragment에 구글맵 그리기                 | p287-2     |



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

내 위치 > 경도, 위도 요청

```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
```

내 위치 > 지도에 파랑색 표시

```xml
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
```

# 구글맵 표시

## MainActiviy에서 그리기

### 템플릿 활용

projoect : p674

### Empty에서 그리기

project : p675

1. google Console에 패키지 정보 입력
2. build.gradle에 googleMap API 추가 - sync now
3. androidManifest.xml에 key값 입력

build.gradle

```
implementation 'com.google.android.gms:play-services-maps:17.0.0'
```



## Fragment에서 지도 그리기

**MapView를 사용하는게 포인트**

```xml
<com.google.android.gms.maps.MapView ...
```

Fragment에서 지도를 뿌릴때는 Acitivity에서 해야..?

Fragment3.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#009688"
    android:orientation="vertical">
    <com.google.android.gms.maps.MapView
        android:id="@+id/map"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:name="com.google.android.gms.maps.SupportMapFragment"
        />
</LinearLayout>
```





