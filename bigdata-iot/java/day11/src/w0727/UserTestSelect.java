package w0727;

public class UserTestSelect {
	public static void main(String[] args) {
		Db<Integer, Product> db = new ProductDb("db", "db");
		Product pResult = null;
		try {
			pResult = db.select(103);
			System.out.println("OK");
			System.out.println(pResult);

		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
}
