package com.test;

import com.biz.MenuDb;
import com.frame.Db;
import com.vo.Menu;

public class SelectMenuTest {
	public static void main(String[] args) {
		Db<String, Menu> db = new MenuDb("db", "db");
		try {
			System.out.println(db.select("PIZZA").getPrice());
			
		} catch (Exception e) {
			System.out.println("error");
		}

	}

}
