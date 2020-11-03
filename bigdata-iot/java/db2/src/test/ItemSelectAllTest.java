package test;

import java.util.ArrayList;

import controller.ItemController;
import frame.Controller;
import vo.Item;

public class ItemSelectAllTest {

	public static void main(String[] args) {
		Controller<String, Item> controller = new ItemController();
		ArrayList<Item> list = new ArrayList<Item>();
		
		try {
			list = controller.get();
			for (Item i : list) {
				System.out.println(i);
			}
			System.out.println("Get OK");
		} catch (Exception e) {
			System.out.println("Get Fail");
			e.printStackTrace();
		}
	}

}

