package com.example.nfctest.nfc;

/*

이클래스는 설명할것이 딱히 없지만, 굳이 설명해보자면,

차후에 UriRecord클래스와 TextRecord클래스에서도 보겠지만,

nfcrecord에서 데이터를 가져올때, RTD_TEXT인경우에는 1번을가져오고 RTD_URI인경우에는 2번을가져온다.

(차후 디버깅 돌려보면 알게됨)

그 내용을 토대로,  만약 이게 URL이 맞으면 이 메소드를 계속 실행하고 아니면 에러를 던져라

만약 이게 TEXT가 맞으면 이메소드를 계속 실행하고 아니면 에러를 던져라. 이 기능을 위해서 사용한다.

그 내용에 해당하는 소스를 첨부하자면

Preconditions.checkArgument(Arrays.equals(record.getType(),NdefRecord.RTD_TEXT));

*/

public class ParsedRecord {
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_URI = 2;
    public static final int TYPE_CUSTOM_URI = 3;
    public static final int APPICATION = 4;
    public static final int MAIL = 5;
    public static final int CONTACT = 6;
    public static final int PHONE_NUMBER = 7;
    public static final int SMS = 8;
    public static final int LOCATION = 9;
    public static final int ADDRESS = 10;
    public static final int BLUETOOTH = 11;
    public static final int DATA = 12;

    public int getType();
}
