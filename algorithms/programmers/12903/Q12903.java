package practice;

public class Q12903 {
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

	public static void main(String[] args) {
		Q12903 q = new Q12903();
		Q12903.Solution sol = q.new Solution();
		
		String s = "qwer";
		
		System.out.println(sol.solution(s));
		
	}

}
