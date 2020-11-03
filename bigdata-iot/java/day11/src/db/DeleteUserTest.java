package db;

public class DeleteUserTest {

	public static void main(String[] args) {
		Db<String, User> db = new UserDb("127.0.0.1", "db", "db");
		User user = new User("id31", "pw56", "SER");
		try {
			db.delete(user.getId());
			//UserDb.java의 insert 함수에서 catch 예외처리 throw e가 없으면
			//에러 처리가 되지 않고 OK표시됨
			//예외처리 throw하게끔 해서 아래 catch로 진입하여 에러 표시할 수 있도록 
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

}
