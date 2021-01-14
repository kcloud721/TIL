# Q. 42586 : 기능 개발

스택/큐 (2 of 4)

### [문제링크](https://programmers.co.kr/learn/courses/30/lessons/42586)

### 문제설명

프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

### 제한 사항

- 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
- 작업 진도는 100 미만의 자연수입니다.
- 작업 속도는 100 이하의 자연수입니다.
- 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.

### 입출력 예

| progresses               | speeds             | return    |
| ------------------------ | ------------------ | --------- |
| [93, 30, 55]             | [1, 30, 5]         | [2, 1]    |
| [95, 90, 99, 99, 80, 99] | [1, 1, 1, 1, 1, 1] | [1, 3, 2] |





## 나의 풀이

문제 카테고리가 스택/큐 인만큼 스택을 사용해보았음.

1. 기능 개발 100% 달성할 때 까지 남은 날짜 수를 days 배열에 저장
2. days 배열을 한바퀴 돌면서 기능배포 시점을 찾고, 누적 기능 수를 스택에 저장
   * troll : 남들 기다리게 하는 기능의 개발완료까지 남은 날짜 수 
   * taks : 배포시점에 배포할 기능 수

for문을 두 번 사용했지만 한번만 사용하여 풀 수도 있을 것아 시도해보았는데 매우 비직관적이었음.

```java
class Solution {
	public Stack<Integer> solution(int[] progresses, int[] speeds) {
		Stack<Integer> result = new Stack<>();
		int[] days = new int[progresses.length];

		// 진도 100% 달성까지 남은 날짜 수 계산
		for (int i = 0; i < progresses.length; i++) {
			int q = (100 - progresses[i]) / speeds[i];
			int r = (100 - progresses[i]) % speeds[i];
			days[i] = q + ((r == 0) ? 0 : 1);
		}

		int tasks = 0;
		int troll = days[0];

		// 기능 배포시점에서 배포할 기능의 개수 계산
		for (int i = 1; i <= days.length; i++) {
			tasks++;
			if (i == days.length) {
				result.push(tasks);
				break;
			} else if (troll < days[i]) {
				result.push(tasks);
				tasks = 0;
				troll = days[i];
			}
		}

		return result;
	}
}
```

