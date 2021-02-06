# Q. 42577 : 전화번호 목록

## 해시 (2 of 4)

### [문제링크](https://programmers.co.kr/learn/courses/30/lessons/42577)

### 문제 설명

전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

- 구조대 : 119
- 박준영 : 97 674 223
- 지영석 : 11 9552 4421

전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

### 제한 사항

- phone_book의 길이는 1 이상 1,000,000 이하입니다.
- 각 전화번호의 길이는 1 이상 20 이하입니다.

### 입출력 예제

| phone_book                  | return |
| --------------------------- | ------ |
| [119, 97674223, 1195524421] | false  |
| [123,456,789]               | true   |
| [12,123,1235,567,88]        | false  |



## 

## 나의 풀이

### 접근

* 배열 phone_book 에서 문자열의 길이가 가장 작은 문자열부터 비교한다.
* 다른 문자열과 접두사가 일치할 경우 즉시 return false

### java

```java
import java.util.*;

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> maps = new HashMap<>();

		// 해쉬맵에 폰번호String + 번호길이Integer 저장
		for (int i = 0; i < phone_book.length; i++) {
			String phone_num = phone_book[i];
			int num_length = phone_book[i].length();
			maps.put(phone_num, num_length);
		}

		// ** 밸류(번호 길이) 기준으로 오름차순 정렬
		// 1. hashMap.entrySet()으로 Entry 리스트에 key-value 저장
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(maps.entrySet());

		// 2. 비교함수 Comparator를 사용하여 오름차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 오름 차순 정렬
				return obj1.getValue().compareTo(obj2.getValue());

				// 내림 차순 정렬
				// return obj2.getValue().compareTo(obj2.getValue());
			}
		});

		// 함수 비교
		for (int i = 0; i < list_entries.size(); i++) {
			String stdStr = list_entries.get(i).getKey();
			int stdStrSize = stdStr.length();
			for (int j = i + 1; j < list_entries.size(); j++) {
				String nextStr = list_entries.get(j).getKey();
				String compareStr = nextStr.substring(0, stdStrSize);
				if (stdStr.equals(compareStr)) {
					answer = false;
					return answer;
				}
			}
		}
		return answer;
	}
}
```

### 리뷰

문자열의 길이를 기준으로 정렬하고자 했다.

1. 문자열을 key, 문자열 길이를 value로 하여 해시맵 생성

2. 해시맵의 value 기준으로 오름차순 정렬

그런데 다른 풀이를 보니 굳이 이렇게 복잡하게 안했어도 됐군.



## 다른 사람의 풀이

### 1. startsWith 메서드를 활용하여 두 문자열을 서로 체크

정렬을 하지 따로 않았기 때문에 비교할 두 문자열 중 어느 것이 더 짧은 것인지 모른다. 따라서 둘 다 비교함.

```java
class Solution {
    public boolean solution(String[] phoneBook) {
       for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}
```



### 2. 배열 정렬 후 startsWith() 체크

주어진 문자열을 Arrays.sort() 로 사전정렬을 수행한 후 startsWith()로 문자열을 비교한다.

비슷한 것이 근처에 있도록 정렬을 해주었기 때문에 for문을 두 번 돌리지 않아도 된다. 가장 간단하면서 빠른 방법인듯!

```java
class Solution{
    public boolean solution(String[] phone_book){
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }

        return answer;
    }
}
```

