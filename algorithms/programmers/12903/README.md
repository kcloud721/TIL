# Q. 12903 : 가운데 글자 가져오기

## 문제

[링크](https://programmers.co.kr/learn/courses/30/lessons/12903)

## Sol. 1

짝수/홀수인 경우 나누고, 문자열길이/2 해서 문자 지정하고자 했음

### 그전에 난 쪼랭이니까 하나하나 짚고 넘어가야함

#### 1. n번째 문자를 지정하는 방법 : charAt()

문자열에서 인자로 주어진 값에 해당하는 문자를  `character` 형으로 리턴한다.

```java
charAt(index)
```

#### 2. char to string : toString

charAt() 의 리턴값은 character 인데, 문제의 answer 는 String 이므로 `char ▷ string` 해야 함

```java
Character.toString()
```

참조 : 자바 String을 Char로, Char를 String으로 변환하기 [🔗](https://kutar37.tistory.com/entry/%EC%9E%90%EB%B0%94-String%EC%9D%84-Char%EB%A1%9C-Char%EB%A5%BC-String%EC%9C%BC%EB%A1%9C-%EB%B3%80%ED%99%98%ED%95%98%EA%B8%B0)

#### 3. 문자열 붙이기 : concat

이건 C에서도 배웠던 건데 까묵

```java
String A = "123";
String B = "abc";
String result = A.concat(B);
```

```bash
> 123abc
```

### 그래서 나의 풀이

```java
class Solution {
	    public String solution(String s) {
	        String answer = "";
	        if(s.length()%2 == 1) {	// 홀 
	        	answer = Character.toString(s.charAt(s.length()/2));
	        }else {	// 짝 
	        	String temp1 = Character.toString(s.charAt(s.length()/2-1));
	        	String temp2 = Character.toString(s.charAt(s.length()/2));
	        	answer = temp1.concat(temp2);	        	
	        }
	        return answer;
	    }
	}
```

다른 사람의 풀이를 보니 substring을 썼더군. 그래서 나도 substring을 써서 다시 풀어보았다.

## Sol. 2

### substring 짚고 넘어가기

문자열을 자르는 함수

```java
String str = "ABCDEFG";
str.substring(3);		// (시작위치) : DEFG
srt.substring(3,6);	// (시작위치,끝위치) : DEF
```

참고 : [문자열 자르기(Substring, Split) 사용법 & 예제](https://coding-factory.tistory.com/126)

### 그래서 나의 두 번째 풀이

```java
class Solution {
	    public String solution(String s) {
	        String answer = "";
	        int a = s.length();
	        if(s.length()%2 == 1) {	// 홀 
	        	answer = s.substring(a/2 ,a/2 + 1);
	        }else {	// 짝 
	        	answer = s.substring(a/2 - 1 ,a/2 + 1);	
	        }
	        return answer;
	    }
}
```

charAt 뭐시기 필요없이 substring 하나로 끝낼 수 있구낭





