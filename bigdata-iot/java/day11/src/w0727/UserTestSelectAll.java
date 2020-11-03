package w0727;

import java.util.ArrayList;

public class UserTestSelectAll {
	public static void main(String[] args) {
		Db<Integer, Product> db = new ProductDb("db", "db");
		ArrayList<Product> list = null;
		try {
			list = db.select();
			System.out.println("OK");
			for(Product p:list)
				System.out.println(p);

		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
}
