package com.test;
import com.biz.MenuDb;
import com.frame.Db;
import com.vo.Menu;

public class DeleteMenuTest {

	public static void main(String[] args) {
		Db<Integer, Menu> db = new MenuDb("db", "db");
		Menu M = new Menu("PIZZA", 30000);
		try {
			db.deleteM(M);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}		
	}

}
