package com.test;

import java.util.ArrayList;

import com.biz.TableDb;
import com.frame.Db;
import com.vo.Table;

public class SelectAllTableTest {

	public static void main(String[] args) {
		Db<Integer, Table> db = new TableDb("db", "db");
		ArrayList<Table> alist = new ArrayList<Table>();

		try {
			alist = db.selectAll();
			for (Table table : alist) {
				System.out.println(table);
			}
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}

	}

}
