package com.test;

import com.biz.TableDb;
import com.biz.UserDb;
import com.vo.Table;

public class UpdateUserTest {

	public static void main(String[] args) {
		Db<String, Table> db = new UserDb("127.0.0.1", "db", "db");
		int tableno = 1;
		String menus = "COKE";
		Table table = new Table(tableno, menus);
		Db<String, Table> tableDb = null;
		//Db<Integer, DinningTable> db = new DinningTable(1, "PIZZA");
		try {
			tableDb.update(table);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
}
