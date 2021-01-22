package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Q42577 {
	class Solution {
	    public boolean solution(String[] phone_book) {
	        boolean answer = true;
	        HashMap<String, Integer> maps = new HashMap<>();
	        
	        // 해쉬맵에 폰번호+길이 저장 
	        for(int i=0; i<phone_book.length; i++) {
	        	String phone_num = phone_book[i];
	        	int num_length = phone_book[i].length();
	        	maps.put(phone_num, num_length);
	        }
	        
	        //밸류 기준으로 오름차순 정렬
	       Collections.sort(keySetList, );
	        
	        // 하나 씩 비교해봐야..? 
	        
	        return answer;
	    }
	}
	
	public static List sortByValue(final HashMap maps) {
		ArrayList<String> list = new ArrayList();
		list.addAll(maps.keySet());
		
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				Object v1 = maps.get(o1);
				Object v2 = maps.get(o2);
				
				return ((Comparable) v2).compareTo(v1);
			}
		});
		
		Collections.reverse(list);
		return list;
		
	}

	public static void main(String[] args) {
		Q42577 q = new Q42577();
		Q42577.Solution sol = q.new Solution();
		
		String[] phone_book = {"97674223", "119", "1195524421"};
		
		System.out.println(sol.solution(phone_book));
	}

}
