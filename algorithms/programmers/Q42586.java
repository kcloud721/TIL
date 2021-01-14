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