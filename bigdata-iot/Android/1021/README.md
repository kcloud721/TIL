| 과목                                                         | 프로젝트명 |
| ------------------------------------------------------------ | ---------- |
| 진동, 알림(Notification)                                     | p701       |
| Firebase 를 통한 알림 수신 : Web 서버와 연동<br />수신된 메시지를 MainActivity에서 처리 (토스트 메시지) | p711       |
| Firebase 에서 메시지를 수신하면<br />알림팝업, 진동발생      | p712       |

# Notification

project : p701

# Firebase

## step 1

https://console.firebase.google.com/ 에서 프로젝트 만들고 앱등록 가이드대로 따라하기

1. 앱 등록
2. 구성 파일 다운로드
3. Firebase SDK 추가 
4. 앱 실행 설치 확인은 패스

* bundle.gradle (Module:app)

```xml
implementation platform('com.google.firebase:firebase-bom:25.12.0')
    implementation 'com.google.firebase:firebase-messaging:20.0.0'
    implementation 'com.google.firebase:firebase-core:17.2.0'
    implementation 'com.google.firebase:firebase-analytics'
```

* `Sync Now` 필수 실행

* FirebaseMessaging: MainActivity 뒤에서 푸쉬 메시지를 받기위한 서비스

ex) push 서버로 전세계 공장 컨트롤 ..



## step 2

Eclipse 의 웹서버를 통해 Push 전송

1. `Eclipse Web Servlet (Ftest.java)` 에 FireBase push 전송하는 명령어

2. 해당 URL로 진입하면 (http://192.0.0.0/ftest) FireBase push 서버에 데이터 전송

3. 안드로이드 앱에서 메시지 수신

   Log.d 로 확인

4. 수신된 정보를 TextView에 띄움

5. 수신된 정보를 Toast로 띄움

6. 수신된 정보를 팝업 알림창으로 띄움 (미해결)





