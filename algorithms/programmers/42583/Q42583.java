package stackQue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Q42583 {
	class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int count_time = 0;
	        Queue<Integer> waiting = new LinkedList<>();
	        Queue<Integer> completed = new LinkedList<>();
	        int[] info = new int[2];
	        HashMap<String, int[]> maps = new HashMap<>();
	        Queue<HashMap> on_bridge = new LinkedList<>();
	        int on_bridge_weight = 0;
	        
	        for(int i=0; i<truck_weights.length; i++) {
	        	waiting.add(truck_weights[i]);
	        }
	        
	        int i = 0;
	        
	        // 일단 처음엔 그냥 조건 없이 다리 위로 
	        info[0] = truck_weights[i];	// 무게 
	        info[1] = 1; // 위치 
	        maps.put("t0", info);	//maps에 할당 
	        on_bridge_weight += truck_weights[i];	// 다리 무게 추가 
	        i++;
	        count_time++;
	        System.out.println(maps);
	        System.out.println(Arrays.toString(maps.get("t0")));
	        
	        
	        while(completed.size() != truck_weights.length) {
	        	if(on_bridge_weight <= weight) {	// 다리무게 견딜 수 있을 경우 다리에 탑승 
	        		info[0] = truck_weights[i];
	        		info[1] = 1;
	        		maps.put("t" + i, info);
	        		on_bridge_weight += truck_weights[i];
	        		i++;
 	        	} else {	// 견딜 수 없으면 다리에 오를 수 없음 

	        	}
	        	
	        	// 다리 위 트럭들 한칸 이동
	        	
        		count_time++;

	        	
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

class truckInfo{
	int weights;
	int location;
	
	public truckInfo() {
		
	}

	public truckInfo(int weights, int location) {
		this.weights = weights;
		this.location = location;
	}

	public int getWeights() {
		return weights;
	}

	public void setWeights(int weights) {
		this.weights = weights;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
	
	
	
}