import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> maps = new HashMap<>();

		// 해쉬맵에 폰번호String + 번호길이Integer 저장
		for (int i = 0; i < phone_book.length; i++) {
			String phone_num = phone_book[i];
			int num_length = phone_book[i].length();
			maps.put(phone_num, num_length);
		}

		// ** 밸류(번호 길이) 기준으로 오름차순 정렬
		// 1. hashMap.entrySet()으로 Entry 리스트에 key-value 저장
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(maps.entrySet());

		// 2. 비교함수 Comparator를 사용하여 오름차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 오름 차순 정렬
				return obj1.getValue().compareTo(obj2.getValue());

				// 내림 차순 정렬
				// return obj2.getValue().compareTo(obj2.getValue());
			}
		});

		// 함수 비교
		for (int i = 0; i < list_entries.size(); i++) {
			String stdStr = list_entries.get(i).getKey();
			int stdStrSize = stdStr.length();
			for (int j = i + 1; j < list_entries.size(); j++) {
				String nextStr = list_entries.get(j).getKey();
				String compareStr = nextStr.substring(0, stdStrSize);
				if (stdStr.equals(compareStr)) {
					answer = false;
					return answer;
				}
			}
		}
		return answer;
	}
}