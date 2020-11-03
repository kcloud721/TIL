package com.test;

import com.biz.TableDb;
import com.frame.Db;
import com.vo.Table;

public class InsertTableTest {

	public static void main(String[] args) {
		Db<Integer, Table> db = new TableDb("db", "db");
		Table sample = new Table(101, "KIMCHIs");
		try {
			db.insert(sample);
			System.out.println("ok");
			//db.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERR");
		}

	}

}
