package hash;

import java.util.Arrays;

public class Q42576_2 {
	class Solution {
	    public String solution(String[] participant, String[] completion) {
	    	Arrays.sort(participant);
	    	Arrays.sort(completion);
	    	
	        String answer = "";
	        String exist = "";
	        int cnt = 0;
	    	for(int i=0 ; i<participant.length ; i++) {
	    		exist = "N";
	    		for(int j=cnt ; j<completion.length ; j++){
	    			if(participant[i].equals(completion[j])) {
	    				exist = "Y";
	    				completion[j] = null;
	    				cnt = j;
	    				break;
	    			}
	    		}
	    		if(exist.equals("N")) {
	    			answer = participant[i];
	    			return answer;
	    		}
	    	}
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		String[] participant = new String[] {"mislav", "stanko", "mislav", "ana"};
		String[] completion = new String[] {"stanko", "ana", "mislav"};
		
		Q42576_2 q = new Q42576_2();
		Q42576_2.Solution sol = q.new Solution();
		
		String answer = sol.solution(participant, completion);
		System.out.println(answer);

	}

}
