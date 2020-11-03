package test;

import controller.ItemController;
import frame.Controller;
import vo.Item;

public class ItemDeleteTest {

	public static void main(String[] args) {
		//Item i = new Item("cup", 8000);
		Controller<String, Item> controller = new ItemController();
		try {
			controller.remove("103");
			System.out.println("Register OK");
		} catch (Exception e) {
			System.out.println("Register Fail");
			e.printStackTrace();
			
		}
	}

}

