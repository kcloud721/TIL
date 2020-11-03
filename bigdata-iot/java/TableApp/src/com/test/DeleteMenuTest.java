
package com.test;

import com.biz.MenuDb;
import com.frame.Db;
import com.vo.Menu;

public class DeleteMenuTest {
	public static void main(String[] args) {
		Db<String, Menu> db = new MenuDb("db", "db");
		String s = "bobssss";
		try {
			db.delete(s);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
}
