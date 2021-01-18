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
	        HashMap<String, int[][]> maps = new HashMap<>();
	        Queue<HashMap> on_bridge = new LinkedList<>();
	        int[][] info = new int[truck_weights.length][2];
	        int on_bridge_weight = 0;
	        
	        for(int i=0; i<truck_weights.length; i++) {
	        	waiting.add(truck_weights[i]);
	        }
	        
	        int i = 0;
	        
	        // 일단 처음엔 그냥 조건 없이 다리 위로 
	        truckInfo t1 = new truckInfo("t1", truck_weights[i], 1);
	        
	        info[i][0] = truck_weights[i];	// 무게 
	        info[i][1] = 1; // 위치 
	        maps.put("t0", info);	//maps에 할당 
	        on_bridge_weight += truck_weights[i];	// 다리 무게 추가 
	        i++;
	        count_time++;
	        System.out.println(maps);
	        System.out.println("jihi" + Arrays.deepToString(maps.get("t0")));
	        
	        
	        while(completed.size() != truck_weights.length) {
	        	if(on_bridge_weight <= weight) {	// 다리무게 견딜 수 있을 경우 다리에 탑승 
	        		info[i][0] = truck_weights[i];	// 무게 
	    	        info[i][1] = 1; // 위치 
//	        		maps.put("t" + i, info[i][]);
	        		on_bridge_weight += truck_weights[i];
	        		i++;
 	        	} else {	// 견딜 수 없으면 다리에 오를 수 없음 

	        	}
	        	
	        	// 다리 위 트럭들 한칸씩 이동
	        	System.out.println(maps);
	        	System.out.println(Arrays.deepToString(maps.get("t0")));
	        	System.out.println(Arrays.deepToString(maps.get("t1")));
	        	break;
	        	// 끝까지 이동한 트럭 completed에 옮김 
	        	
//        		count_time++;

	        	
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
	String id;
	int weights;
	int location;
	
	public truckInfo() {
		
	}

	public truckInfo(String id, int weights, int location) {
		this.id = id;
		this.weights = weights;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "truckInfo [id=" + id + ", weights=" + weights + ", location=" + location + "]";
	}

		
	
	
}