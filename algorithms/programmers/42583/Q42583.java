package stackQue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Q42583 {
	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int count_time = 0;
	        Queue<Integer> waiting = new LinkedList<>();
	        Queue<Integer> completed = new LinkedList<>();
	        HashMap<String, Integer> maps = new HashMap<>();
	        Queue<HashMap> on_bridge = new LinkedList<>();
	        int on_bridge_weight = 0;
	        
	        for(int i=0; i<truck_weights.length; i++) {
	        	waiting.add(truck_weights[i]);
	        }
	        
	        System.out.println(waiting.poll());
	        int i = 0;
	        System.out.println(Integer.toString(truck_weights[i]));
	        
	        while(completed.size() != truck_weights.length) {
	        	if(on_bridge_weight <= weight) {	// 다리무게 견딜 수 있을 경우 건너 
	        		System.out.println("truck_weights[" + i + "]");
	        		maps.put("truck_weights[" + i + "]", 1);
	        	}
	        }
	        
	        System.out.println(waiting);
	        
	        
	        return count_time;
	    }
	}

	public static void main(String[] args) {
		Q42583 q = new Q42583();
		Q42583.Solution sol = q.new Solution();
		
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		
		System.out.println(sol.solution(bridge_length, weight, truck_weights));

	}

}
