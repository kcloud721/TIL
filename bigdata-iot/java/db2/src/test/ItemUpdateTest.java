package test;

import controller.ItemController;
import frame.Controller;
import vo.Item;

public class ItemUpdateTest {

	public static void main(String[] args) {
		Item i = new Item(1144,"mouse", 15000);
		Controller<String, Item> controller = new ItemController();
		try {
			controller.modify(i);
			System.out.println("Modify OK");
		} catch (Exception e) {
			System.out.println("Modify Fail");
			e.printStackTrace();
		}
	}

}

