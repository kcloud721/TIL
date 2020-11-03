package test;

import controller.ItemController;
import frame.Controller;
import vo.Item;

public class ItemInsertTest {

	public static void main(String[] args) {
		Item i = new Item("cup1", 8000);
		Controller<String, Item> controller = new ItemController();
		try {
			controller.register(i);
			System.out.println("Register OK");
		} catch (Exception e) {
			System.out.println("Register Fail");
			e.printStackTrace();
		}
	}

}

