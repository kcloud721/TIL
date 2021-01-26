import java.util.*;

class Solution {
	public int solution(int[] food_times, long k) {
		int answer = 0;
		int header = 0;
		ArrayList<foodInfo> arr = new ArrayList<>();

		for (int i = 0; i < food_times.length; i++) {
			foodInfo fi = new foodInfo(i + 1, food_times[i]);
			arr.add(fi);
		}

		for (long i = 0; i < k; i++) {
			if (arr.size() == 0) {
				answer = -1;
				return answer;
			}
			if (header + 1 > arr.size()) {
				header %= arr.size();
			}

			int thisFoodSize = arr.get(header).getFoodSize();
			arr.get(header).setFoodSize(thisFoodSize - 1);

			if (arr.get(header).getFoodSize() == 0) {
				arr.remove(header);
				// System.out.println(arr + " >> remove and header : " + header);
				continue;
			}

			header = (header + 1) % arr.size();
			// System.out.println(arr + "next header : " + header);
		}

		// System.out.println("header " + header );

		if (arr.size() == 0) {
			answer = -1;
		} else
			answer = arr.get(header).getIndex();

		return answer;
	}
}

class foodInfo {
	int index;
	int foodSize;

	public foodInfo() {

	}

	public foodInfo(int foodSize) {
		this.foodSize = foodSize;
	}

	public foodInfo(int index, int foodSize) {
		this.index = index;
		this.foodSize = foodSize;
	}

	public int getIndex() {
		return this.index;
	}

	public int getFoodSize() {
		return this.foodSize;
	}

	public void setFoodSize(int foodSize) {
		this.foodSize = foodSize;
	}

	@Override
	public String toString() {
		return "{ " + this.index + ", " + this.foodSize + " }";
	}
}