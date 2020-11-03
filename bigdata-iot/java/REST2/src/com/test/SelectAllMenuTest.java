package com.test;

import java.util.ArrayList;

import com.biz.MenuDb;
import com.frame.Db;
import com.vo.Menu;

public class SelectAllMenuTest {

	public static void main(String[] args) {
		Db<Integer, Menu> db = new MenuDb("db", "db");
		ArrayList<Menu> alist = new ArrayList<Menu>();

		try {
			alist = db.selectAll();
			for (Menu menu : alist) {
				System.out.println(menu);
			}
		} catch (Exception e) {
			System.out.println("error");
		}

	}

}
