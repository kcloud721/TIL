# 소소한 java

## 공백을 포함하여 `Scanner(System.in);` 하기

공백까지 포함하여 입력받고 싶을 땐 `nextLine()` 을 쓴다.

```java
Scanner sc = new Scanner(System.in);
String a = sc.nextLine();
```



## 온점(.)을 기준으로 spilt하기

그냥 `split(".");` 하면 안된다. 정규식에서 온점은 "불특정 문자 1개" 라는 의미라고 함.

해결 방법 : 

```java
spilt("\\.");
spilt("[.]");
```



## int의 범위를 넘어선 숫자 처리

자바는 `unsigned int`  가 없음. `unsigned` 는 `char` 형만 지원한다고 함

* `long` 을 사용하면 됨

> 참고 : int의 범위는 -2147483648 ~ +2147483647

* double 은 소수에 적합
* long 은 정수에 적합



## #반올림

#### Math.round()

> 올림은 Math.ceil(); 
>
> 버림은 Math.floor();

```java
double pie = 3.14159265358979;
System.out.println(Math.round(pie)); //결과 : 3
System.out.println(Math.round(pie*100)/100.0); //결과 : 3.14
System.out.println(Math.round(pie*1000)/1000.0); //결과 : 3.142
```

#### String.format()

```java
double pie = 3.14159265358979;
double money = 4424.243423;
System.out.println(String.format("%.2f", pie)); //결과 : 3.14
System.out.println(String.format("%.3f", pie)); //결과 : 3.142
System.out.println(String.format("%,.3f", money)); //결과 : 4,424.243
```



## float 와 double

double은 float의 2배 이상의 실수 저장 가능

![img](md-images/pimg6145_1.png)



## 진수 변환 (Integer)

### 10진수 ➡️ 2/8/16 진수

```java
int i = 127;
String binaryString = Integer.toBinaryString(i); //2진수
String octalString = Integer.toOctalString(i);   //8진수
String hexString = Integer.toHexString(i);       //16진수
```

### 2/8/16진수 ➡️ 10진수

```java
// 8진수를 입력받아 10진수로 변환하는 예
String a = sc.next();
System.out.println(Integer.valueOf(a, 8));
```



## Double의 지수 표현 제거

* NumberFormat

  ```java
  double num = 4.82811884E8;
   
  NumberFormat f = NumberFormat.getInstance();        
  f.setGroupingUsed(false);        
   
  System.out.println(f.format(num));
  ```

* BigDemical

  ```java
  String  value = "482811884";
  //or double value = 4.82811884E8;
   
  BigDecimal bigDecimal = new BigDecimal(value);
  System.out.println(bigDecimal.toString());
  ```

  

  

## 대문자 <-> 소문자 변환

```java
hexString.toUpperCase();	// to 대문자
hexString.toLowerCase();	// to 소문자
```



### * int 범위를 초과하는 숫자를 연산해야할 경우

* int 대신 long 자료형 사용

* math 패키지의 BigInteger 패키지 사용

  정수로만 이루어진 String 을 받음

  ```java
  import java.math.BigInteger;
  public static void main(String[] args) { 
    BigInteger a = new BigInteger("100000000000000000000000000000000000");
    System.out.println(a);
  }
  ```

  출처: https://javariankm.tistory.com/26 [자바리안의 메모장]

## 소수점 자리 표현 & 반올림

소수점 이하 셋째 자리에서 반올림하여 둘째자리까지 출력

```java
System.out.println(String.format("%.2f", a / (double)b));
```



## 자바의 논리연산

* AND : `&`
* OR : `|`
* XOR : `^`
* NOT : `~`



## 삼항연산

![삼항연산자](md-images/99375E495C020AB503.jpeg)

ㅊㅊ : https://coding-factory.tistory.com/266

* 중첩하여서 비교도 가능

  ```java
  int a = (a<b ? a:b)<c ? (a<b ? a:b) : c;
  ```




## BufferWriter

`System.out.println();` 의 출력 속도는 매우 느림

참고 : https://www.acmicpc.net/blog/view/57

IDE에서는 실행 잘 되는데 채점할 때 시간초과가 난다면 이 함수가 원인일 수도..

```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write("hi..!\n");
bw.flush();
bw.close();
```



## switch - case 문에서 AND/OR

```java
int a = sc.nextInt();
switch(a) {
		case 12:
		case 1:
		case 2:
			System.out.println("winter");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("spring");
			break;
```



## 