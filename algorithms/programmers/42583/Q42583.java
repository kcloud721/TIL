import java.util.*;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int count_time = 0;
		Queue<truckInfo> waitingQ = new LinkedList<>();
		Queue<truckInfo> progressQ = new LinkedList<>();
		Queue<truckInfo> completedQ = new LinkedList<>();
		int on_bridge_weight = 0;

		for (int i = 0; i < truck_weights.length; i++) {
			String truckId = "t" + i;
			int truckWeights = truck_weights[i];
			int truckLoc = 0;
			truckInfo t = new truckInfo(truckId, truckWeights, truckLoc);
			waitingQ.add(t);
		}

		while (completedQ.size() != truck_weights.length) {
			if (progressQ.size() != 0) {
				if (progressQ.element().getLocation() == bridge_length) {
					// 끝까지 이동한 트럭 completed에 옮김
					on_bridge_weight -= progressQ.element().getWeights(); // 다리 무게 다시 감소
					completedQ.add(progressQ.poll()); // 큐 이동
					System.out.println("BYE");
				}
			}

			if (waitingQ.size() != 0) {
				if (on_bridge_weight + waitingQ.element().getWeights() <= weight) { // 다리무게 견딜 수 있을 경우 waiting 트럭 탑승
					on_bridge_weight += waitingQ.element().weights; // 다리 무게 카운트
					progressQ.add(waitingQ.poll()); // 진행중 큐로 옮김
				}
			}

			// 다리 위 트럭들 한칸씩 이동
			for (truckInfo prog : progressQ) {
				prog.setLocation(prog.getLocation() + 1);
			}

			// 경과시간 카운트
			count_time++;

			// System.out.println(waitingQ);
			// System.out.println(progressQ);
			// System.out.println(completedQ);
			// System.out.println("경과시간 " + count_time);
			// System.out.println();

		}

		return count_time;
	}
}

class truckInfo {
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