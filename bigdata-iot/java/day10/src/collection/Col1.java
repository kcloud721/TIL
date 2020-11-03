package collection;

import java.util.ArrayList;

public class Col1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(4);
		for(int in:list) {
			System.out.println(in);
		}
		
		//모든 데이터형 수용 가능
		ArrayList<Object> list2 = new ArrayList<>();
		list2.add(9);
		list2.add(9.1);
		list2.add("Aa");
		for(Object in:list2) {
			System.out.println(in);
		}
		
		ArrayList<User> list3 = new ArrayList<>();
		list3.add(new User("id01", "pw01", "KIM"));
		list3.add(new User("id02", "pw02", "LEE"));
		list3.add(new User("id03", "pw03", "SEO"));
		for(User in:list3) {
			System.out.println(in);
		}
	}

}
