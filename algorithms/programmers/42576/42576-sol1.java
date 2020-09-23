class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		String exist = "";
		for (int i = 0; i < participant.length; i++) {
			exist = "N";
			for (int j = 0; j < completion.length; j++) {
				if (participant[i].equals(completion[j])) {
					exist = "Y";
					completion[j] = null;
					break;
				}
			}
			if (exist.equals("N")) {
				answer = participant[i];
				return answer;
			}
		}
		return answer;
	}
}