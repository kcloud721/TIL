package com.test;

import com.biz.TableDb;
import com.frame.Db;
import com.vo.Table;

public class UpdateUserTest {

	public static void main(String[] args) {
		Db<Integer, Table> db = new TableDb("db", "db");
		Table table = new Table(2, "PIZZA");
		try {
			db.update(table);
			//db.select(table);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
}
