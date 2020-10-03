# 42576 : 완주하지 못한 선수

https://programmers.co.kr/learn/courses/30/lessons/42576

## 문제 설명

수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

## 제한사항

- 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
- completion의 길이는 participant의 길이보다 1 작습니다.
- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
- 참가자 중에는 동명이인이 있을 수 있습니다.



## 풀이

### 42576-sol1.java

배열과 반복문을 써서 풀면 답은 알맞게 나오지만 응답시간이 길어 실패. 시간복잡도를 고려해서 다시 풀 필요가 있음

### 42576-sol2.java

java는 배열을 정렬할 수 있는 `sort` 함수를 제공한다.

#### 	Arrays.sort에 대하여

```java
int num[] = {37, 27, 40, 30, 28, 19};
System.out.println(Arrays.toString(num));

Arrays.sort(num);
System.out.println(Arrays.toString(num));
```

```java
[37, 27, 40, 30, 28, 19]
[19, 27, 28, 30, 37, 40]
```

오름차순으로 정렬됨을 확인할 수 있음!

`sol1` 코드 앞에 `Arrays.sort` 만 붙여봤으나 이 역시 효율성 테스트에서 `케이스1`을 제외하고는 통과하지 못했다. 이미 정렬되어있기 때문에 for 문을 굳이 처음부터 돌릴 필요가 없는 것이다. `cnt` 변수를 추가하여 `j` for문의 시작점을 `0` 이 아닌 `cnt` 로 지정하면 성공!

### 42576-sol3.java

문제 분류가 HashMap으로 되어있으므로 이를 사용하여 풀이해보자!

#### [HashMap에 대하여](/HashMap.md)



### Heap.java

​	분명 배웠던건데 새롭냐