package com.test;
import com.biz.MenuDb;
import com.frame.Db;
import com.vo.Menu;

public class UpdateMenuTest {

	public static void main(String[] args) {
		Db<String, Menu> db = new MenuDb("db", "db");
		Menu m = new Menu("RICE", 10000000);
		try {
			db.update(m);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}		
	}

}
