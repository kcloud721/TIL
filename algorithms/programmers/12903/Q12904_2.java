package practice;

public class Q12904_2 {
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

	public static void main(String[] args) {
		Q12904_2 q = new Q12904_2();
		Q12904_2.Solution sol = q.new Solution();
		
		String s = "qwer";
		
		System.out.println(sol.solution(s));
		
	}

}
