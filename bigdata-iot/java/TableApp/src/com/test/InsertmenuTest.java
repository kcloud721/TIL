package com.test;
 
import com.biz.MenuDb;
import com.frame.Db;
import com.vo.Menu;
 
 
public class InsertmenuTest {
 
    public static void main(String[] args) {
        Db<String, Menu> db = new MenuDb("db", "db");
        Menu sample = new Menu("bobssss", 77);
        try {
            db.insert(sample);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERR");
        }
    }
 
}
 