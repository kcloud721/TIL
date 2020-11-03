package collection;

import java.util.HashMap;
import java.util.Set;

public class Col4 {

	public static void main(String[] args) {
		HashMap<String, User> map = new HashMap<>();
		map.put("id01", new User("id01", "pwd01", "lee"));
		//Å°°ª : "id01"
		map.put("id02", new User("id02", "pwd02", "de"));
		map.put("id03", new User("id03", "pwd03", "weee"));
		map.remove("id02");
		
		System.out.println(map);
		
		User user = map.get("id01");
		System.out.println(user);
		System.out.println("====");
		
		Set<String> keys = map.keySet();
		for(String s:keys) {
			User u = map.get(s);
			System.out.println(u);
		}
	}

}
