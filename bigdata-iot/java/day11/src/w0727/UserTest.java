package w0727;

public class UserTest {
	public static void main(String[] args) {
		Db<Integer, Product> db = new ProductDb("db", "db");
		Product p = new Product(105, "SGG", 28300, 10.0);
		try {
			db.update(p);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
}
