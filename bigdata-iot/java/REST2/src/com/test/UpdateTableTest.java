package com.test;

import com.biz.TableDb;
import com.frame.Db;
import com.vo.Table;

public class UpdateTableTest {

	public static void main(String[] args) {
		Db<Integer, Table> db = new TableDb("db", "db");
		Table t = new Table(2, "CURRY");
		try {
			db.update(t);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}		

	}

}
