package com.test;

import com.biz.TableDb;
import com.frame.Db;
import com.vo.Table;

public class DeleteTableTest {

	public static void main(String[] args) {
		Db<Integer, Table> db = new TableDb("db", "db");
		try {
			int tableNo=101;
			db.delete(tableNo);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}

}
