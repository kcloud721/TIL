package test;

import java.util.ArrayList;
import java.util.Comparator;

public class Q42891_2 {
	class Solution {
	    public int solution(int[] food_times, long k) {
	    	int answer = 0;
	        ArrayList<foodInfo> arr = new ArrayList<>();
	        
	        // arr에 인덱스와 시간 넣어 초기화 
	        for(int i=0; i<food_times.length; i++) {
	        	arr.add(new foodInfo(i+1, food_times[i]));
	        }
	        
	        System.out.println(arr);
	        
	        // foodSize 기준 오름차순 정렬
	        Comparator<foodInfo> CompFoodSize = new Comparator<foodInfo>() {

				@Override
				public int compare(foodInfo o1, foodInfo o2) {
					// TODO Auto-generated method stub
					return o1.foodSize - o2.foodSize;
				}
	        };
	        
	        arr.sort(CompFoodSize);
	        System.out.println(arr);
	        
	        int i = 0;
	        while(true) {
	        	if(i > k) {
	        		answer = -1;
	        		break;
	        	} else if(arr.get(i).foodSize > k) {
	        		break;
	        	} else {
	        		k -= arr.get(i).foodSize;
	        		i++;
	        	}
	        	System.out.println(k);
	        }
	        
	        System.out.println(arr.get(i).index);
	        answer = arr.get(i).index;
	        
	        
	        return answer;
	    }
	}
	
	

	public static void main(String[] args) {
		Q42891_2 q = new Q42891_2();
		Q42891_2.Solution sol = q.new Solution();
		
		int[] food_times = {1,1,1};
		int k = 5;
		
		System.out.println("ANSWER: " + sol.solution(food_times, k));

	}

}

