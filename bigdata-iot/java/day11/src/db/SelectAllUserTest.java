package db;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectAllUserTest {

	public static void main(String[] args) {
		Db<String, User> db = new UserDb("127.0.0.1", "db", "db");
		ArrayList<User> list = null;
		try {
			list = db.select();
			for(User u:list)
				System.out.println(u);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
}
