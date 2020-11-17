# 소소한 java

### 공백을 포함하여 Scanner(System.in);

공백까지 포함하여 입력받고 싶을 땐 `nextLine()` 을 쓴다.

```java
Scanner sc = new Scanner(System.in);
String a = sc.nextLine();
```



### 온점(.)을 기준으로 spilt하기

그냥 `split(".");` 하면 안된다. 정규식에서 온점은 "불특정 문자 1개" 라는 의미라고 함.

해결 방법 : 

```java
spilt("\\.");
spilt("[.]");
```







