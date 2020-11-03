package com.test;

import java.util.ArrayList;

import com.biz.TableDb;
import com.frame.Db;
import com.vo.Table;

public class TableTestMerged {
	public static void main(String[] args) {
        testinsert();
        testselect();
        testselectall();
        testdelete();
        testselectall();
        testupdate();
        testselectall();
    }
    public static void testinsert() {
        Db<Integer, Table> db = new TableDb("db","db");
        Table sample = new Table(88, "SAMPLE");
        try {
            db.insert(sample);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERR");
        }
    }
    public static void testselect() {
        Db<Integer, Table> db = new TableDb("db", "db");
        int id = 8;
        try {
            System.out.println(db.select(id));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERR");
        }

    }
    public static void testselectall() {
        Db<Integer, Table> db = new TableDb("db", "db");
        ArrayList<Table> list = new ArrayList<Table>();
        try {
            list = db.selectAll();
            for (Table table : list) {
                System.out.println(table);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
    public static void testdelete() {
        Db<Integer, Table> db = new TableDb("db", "db");
        int id = 5;
        try {
            db.delete(id);
        } catch (Exception e) {
            System.out.println("ERR");
            e.printStackTrace();
        }
    }
    public static void testupdate() {
        Db<Integer, Table> db = new TableDb("db", "db");
        Table t = new Table(88, "SUSHI2");
        try {
            db.update(t);
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}
