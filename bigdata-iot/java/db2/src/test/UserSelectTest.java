package test;

import controller.UserController;
import frame.Controller;
import vo.User;

public class UserSelectTest {

	public static void main(String[] args) {
		Controller<String, User> controller = new UserController();
		User user = null;
		try {
			user = controller.get("id01");
			System.out.println(user);
			System.out.println("Get OK");
		} catch (Exception e) {
			System.out.println("Get Fail");
			e.printStackTrace();
		}
	}

}

