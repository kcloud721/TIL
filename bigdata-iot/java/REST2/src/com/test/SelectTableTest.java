package com.test;

import com.biz.TableDb;
import com.frame.Db;
import com.vo.Table;
public class SelectTableTest {

	public static void main(String[] args) throws Exception {
		Db<Integer, Table> db = new TableDb("db", "db");
        int id = 1;
        try {
            System.out.println(db.select(id));
        } catch (Exception e) {
            // TODO: handle exception
        }
	}
}
