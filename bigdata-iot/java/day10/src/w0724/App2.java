package w0724;

public class App2 {

	public static void main(String[] args) {
		Db<String, User> db = new UserDb("192.168.111.1", 1000);
		User user = null;
		try {
			user = db.select("id99");
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
