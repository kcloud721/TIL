# Q. 42748 : K번째 수

## 문제

[링크](https://programmers.co.kr/learn/courses/30/lessons/42748)

##### 문제설명

배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

##### 제한사항

- array의 길이는 1 이상 100 이하입니다.
- array의 각 원소는 1 이상 100 이하입니다.
- commands의 길이는 1 이상 50 이하입니다.
- commands의 각 원소는 길이가 3입니다.



## 풀이

남는 숫자들에 딱 맞는 배열을 만들고 저장하려니, 답을 여러 개 출력해야 하는 만큼 새로운 배열도 여러 번 만들어야 했다.

그래서 나는 앞뒤 제외되는 숫자들을 `0` 으로 바꾸고 남은 숫자들로 정렬하여 연산하고자 했음. (문제 조건에서 array의 원소는 1~100까지 숫자여서 '0' 으로 바꿔도 문제가 없었다.)

```java
class Solution {
	    public int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        int[] temp;
	        int zeros;
			
			for(int i=0; i<commands.length; i++) {
				temp = array.clone();
				zeros = (commands[i][0]-1) + (temp.length-commands[i][1]);
				for(int j=0; j<temp.length; j++) {
					if(j < commands[i][0]-1 || j > commands[i][1]-1)
						temp[j] = 0;
				}
				Arrays.sort(temp);
				answer[i] = temp[zeros+commands[i][2]-1];
			}
	        return answer;
	    }
}
```

테스트케이스 하나 돌리고 채점해봤는데 맞았단다;; 시간복잡도 채점도 안해줘서 잘 푼지도 모르겠다. for문이 두번 돌아서 효율성이 좋을 것 같진 않은데..

다른 사람 풀이 보니까 `copyOfRange` 라는 걸 써서 푸는 게 베스트라고 하고, `sort` 를 아예 코딩으로 구현해서 푼사람도 있더라. 이거 다 알면 좋은거겠지. 써서 다시 풀어보자 나도.



