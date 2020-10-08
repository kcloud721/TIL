package sort;

import java.util.Arrays;

public class Q42748 {
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

	public static void main(String[] args) {
		Q42748 q = new Q42748();
		Q42748.Solution sol = q.new Solution();
		
		int array[] = {1, 5, 2, 6, 3, 7, 4};
		int commands[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		System.out.println(Arrays.toString(sol.solution(array, commands)));
		
		
	}

}
