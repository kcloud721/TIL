package test;

import java.util.ArrayList;
import java.util.Comparator;

public class Q42891_2 {
	class Solution {
	    public int solution(int[] food_times, long k) {
	    	int answer = 0;
	    	int accumMinus = 0;	//시간 차감값 누적 저장 변수
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
	        
	        for(int i=0; i<arr.size(); i++) {
	        	int headTime = arr.get(i).foodSize; // 배열 처음에 있는 수 
	        	int minusTime = 0; // 한번에 뺄 시간 
	        	if(i == 0) {
	        		minusTime = (headTime - accumMinus) * arr.size();
	        	} else {
	        		minusTime = (headTime - accumMinus) * (arr.size()-i);
//	        		System.out.println("arrsize " + arr.size() + " " + i);
	        	}
//	        	System.out.println("headT " + headTime + " accumMinus" + accumMinus);
//        		System.out.println("minusTime " + minusTime);
//	        	System.out.println("headTiem acc minustime " + headTime + " " + accumMinus + " " + minusTime);
	        	
        		System.out.println("headTime i k minusTIme  " + headTime + " " + i + " " + k + " " + minusTime);

	        	if(minusTime > k) {
	        		int answerIndex = (int) (i + (k % (arr.size()-i)) - 1);
	        		answer = arr.get(answerIndex).index;
	        		System.out.println("break : answerIndex " + answerIndex);
	        		break;
	        	} else {
	        		k = k - minusTime;
	        		accumMinus += (headTime - accumMinus);
//	        		System.out.println("k : " + k);
	        	}
	        	
	        	if((i == arr.size()-1) && (k>0)) {
	        		answer = -1;
	        	}
	        }
	        
	        return answer;
	    }
	}
	
	

	public static void main(String[] args) {
		Q42891_2 q = new Q42891_2();
		Q42891_2.Solution sol = q.new Solution();
		
//		int[] food_times = {4,2,3,6,7,1,5,8};
//		int k = 27;
		
		int[] food_times = {1,1,1,1};
		int k = 4;
		
		System.out.println("ANSWER: " + sol.solution(food_times, k));

	}

}

