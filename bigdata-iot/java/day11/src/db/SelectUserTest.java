package db;

import java.util.Arrays;

public class SelectUserTest {

	public static void main(String[] args) {
		Db<String, User> db = new UserDb("127.0.0.1", "db", "db");
		User userResult = null;
		try {
			userResult = db.select("id01");
			System.out.println(userResult);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

}
