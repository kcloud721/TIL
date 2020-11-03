package collection;

import java.util.HashSet;
import java.util.Random;

public class Col3 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>(); //중복되지 않게 숫자 넣음
		//set에 중복않는 숫자 6개
		Random r = new Random();
//		for(int i:set) {
//			set.add(i);
//		}
		while(true){
			set.add(r.nextInt(50));
			if(set.size() == 6)
				break;
		}
		
		//set정보 출력
		System.out.println("size: "+set.size());

		for(int j:set) {
			System.out.println(j);
		}
		
	}

}
