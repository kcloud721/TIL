package com.test;

import java.util.ArrayList;

import com.biz.TableDb;
import com.frame.Db;
import com.vo.Table;
public class SelectGetPrice {

	public static void main(String[] args) throws Exception {
		Db<Integer, Table> db = new TableDb("db", "db");
		ArrayList<String> menus = new ArrayList<String>();
		int id = 7;
		try {
           menus = db.selectM(id);
           System.out.println(menus);
           
           System.out.println(db.getMenuPrice(menus.get(0)));
           
        } catch (Exception e) {
        	System.out.println("Exception");
        }
    }
}
