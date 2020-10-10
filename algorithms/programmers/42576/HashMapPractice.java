package hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapPractice {

	public static void main(String[] args) {
		//선언 
		HashMap<String,String> map1 = new HashMap<String,String>(); //HashMap생성
		HashMap<String,String> map2 = new HashMap<>(); //new에서 타입 파라미터 생략 가능
		HashMap<String,String> map3	= new HashMap<>(map1); //map1의 모든 값을 가진 HashMap 생성
		HashMap<String,String> map4 = new HashMap<>(10); //초기 용량capacity 지정
		HashMap<String,String> map5 = new HashMap<>(10, 0.7f); //초기 capacity, load factor 지정
		HashMap<String,String> map6 = new HashMap<String,String>(){{ //초기값 지정
			put("a","b");
		}};
		
		//값 추가
		HashMap<Integer, String> map = new HashMap<>(); 
		map.put(1, "apple");
		map.put(2, "banana");
		map.put(5, "grape");
		System.out.println(map);
		System.out.println(map.get(1)); //key값으로 value 얻기
		
		//값 출력 
			//entrySet()
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("[Key]:"+ entry.getKey() + " [Value]:"+entry.getValue());
		}
		
			//KeySet()
		for(Integer i : map.keySet()) {
			System.out.println("[key]:"+i+" [Value]:"+map.get(i));
		}
		
			//Iterator - entrySet().iterator()
		Iterator<Entry<Integer, String>> entries = map.entrySet().iterator();
		while(entries.hasNext()) {
			Map.Entry<Integer, String> entry = entries.next();
			System.out.println("[Key]:"+ entry.getKey() +" [Value]:"+ entry.getValue());
		}
		
		//Iterator - keySet().iterator()
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			int key = keys.next();
			System.out.println("[key]:"+ key +" [Value]:"+ map.get(key));
		}
		
		//값 삭제
		map.remove(1); //key값 1 제거
		System.out.println(map);
		map.clear(); //모든 값 제거 
		System.out.println(map);

		
	}

}
