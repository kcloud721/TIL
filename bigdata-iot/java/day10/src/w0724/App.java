package w0724;

public class App {

	public static void main(String[] args) {
		Db db = new UserDb("192.168.111.1", 1000);
		User user = new User("serom", "pwd01", "LEE");
		User user2 = new User("KKK", "pwd22", "LIM");
		try {
			db.insert(user);
			db.update(user2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
