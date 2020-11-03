package test;

import controller.ItemController;
import frame.Controller;
import vo.Item;

public class ItemSelectTest {

	public static void main(String[] args) {
		//Item i = new Item("cup", 8000);
		Controller<String, Item> controller = new ItemController();
		try {
			System.out.println(controller.get("104"));
			System.out.println("Get OK");
		} catch (Exception e) {
			System.out.println("Get Fail");
			e.printStackTrace();
		}
	}

}

