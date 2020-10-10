# 11005 : 진법 변환 2

https://www.acmicpc.net/problem/11005

## 개발력 +1 

### 백준에서 java 제출하기

```java
public class Main { 
	public static void main(String[] args) { 	
    // put your code
  } 
}
```

> class 이름은 꼭 `Main` 이어야 한다!

### Scanner 사용하기

```r
import java.util.Scanner;
```

```java
Scanner sc = new Scanner(System.in);
		String N;
		int B;
		N = sc.next();
		B = sc.nextInt();		// int형은 nextInt() 사용
```

### println 과 print

* println은 값 출력 후 개행 "\n"도 함께 출력
* print는 개행 없이 옆으로 붙여서 출력

테스트케이스 아무리 돌려봐도 맞는데 틀렸다그래서 한 시간을 헤맸는데, 출력 형식이 달라서였다 ㅎ 어이없을무

자바새끼 친해지기 어렵네~~ 이렇게 또 한걸음 가까워졌습니다 👯‍♀️

## 문제 풀이

### Sol. 1

뭔가 더 스마트한 방법이 있을 거라 생각했지만 우선 내가 아는 선에서 풀어보고자,, 하드코딩을 시전함

나머지가 10이상인 경우에 대해 A~Z 대문자를 넣어야 하는데 switch 문을 쓴 것 ㅎㅎ 아니 근데 알파벳이 36개나 돼서 케이스를 36개나 만들어야하는 것이다,, 창피한데 어쩔 수 없지, 생각나는게 이 방법밖에 없는걸

```java
package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q11005_sol1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
//		int N = 8484848;
//		int B = 36;
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		while(N > 0) {
			if(N%B < 10) {
				list.add(Integer.toString(N%B));
				N/=B;
			} else {
				switch(N%B) {
				case 10: list.add("A"); break;
				case 11: list.add("B"); break;
				case 12: list.add("C"); break;
				case 13: list.add("D"); break;
				case 14: list.add("E"); break;
				case 15: list.add("F"); break;
				case 16: list.add("G"); break;
				case 17: list.add("H"); break;
				case 18: list.add("I"); break;
				case 19: list.add("J"); break;
				case 20: list.add("K"); break;
				case 21: list.add("L"); break;
				case 22: list.add("M"); break;
				case 23: list.add("N"); break;
				case 24: list.add("O"); break;
				case 25: list.add("P"); break;
				case 26: list.add("Q"); break;
				case 27: list.add("R"); break;
				case 28: list.add("S"); break;
				case 29: list.add("T"); break;
				case 30: list.add("U"); break;
				case 31: list.add("V"); break;
				case 32: list.add("W"); break;
				case 33: list.add("X"); break;
				case 34: list.add("Y"); break;
				case 35: list.add("Z"); break;
				}
				N/=B;
			}
		}
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i));
		}
	}
}
```

하이고 빌딩 하나 세우셨어 아주;

맞긴하더라고

### sol. 2

다른 사람의 풀이를 찾아봤다.

```java
package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q11006_sol2 {

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		
        List<Character> list = new ArrayList<>();
        while(N > 0) {
            if(N%B < 10) {
                list.add((char)(N%B + '0'));
            } else {
                list.add((char)(N%B + 'A' - 10));
            }
            N/=B;
        }
        for(int i=list.size()-1; i>=0; i--)
            System.out.print(list.get(i));
    }
}
```

여기서 이해가 안됐던 점은 `+ '0'` , `+ 'A' - 10` 부분이었다.

> 0을 왜 더해? 10을 빼고 A를 더하면 0인데 왜 더해?

0을 더하는 건 '0'의 아스키코드(48)을 더하는 거고, 마찬가지로 'A'의 아스키코드(65)를 더하는 것이었다. 아스키코드를 활용해 진법에 따른 값을 넣으려고 하는 것이니, 숫자와 알파벳에서 가장 첫번째인 0과 A의 아스키코드 값을 더해 시작점을 0과 A로 지정하는 것이지.

나머지가 10 이상인 경우 +A와 함께 -10을 한다. 나머지 값(N%B)이 10인 경우를 예로 들면 출발지점이 A(65)가 아니라 A 다음 10번 째인 J(65+10=75)가 반환되는 것이다. 때문에 10을 빼서 출발지점을 A로 설정한다.





