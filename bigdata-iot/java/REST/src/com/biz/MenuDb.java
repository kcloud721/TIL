package com.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Db;
//import com.frame.Sql;
import com.vo.Menu;


public class MenuDb extends Db<Integer, Menu> {
	public MenuDb() {}
	public MenuDb(String dbid, String dbpwd) {
		super(dbid,dbpwd);
	}
	
	@Override
	public void update(Menu menu) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;	
		try {
			con = getConnection();
			pstmt = con.prepareStatement("UPDATE MENU SET NAME=? WHERE PRICE=?");
			pstmt.setString(1, menu.getMenu());
			pstmt.setInt(2, menu.getPrice());
			int result = pstmt.executeUpdate();
			if(result == 0) {
				throw new Exception();
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}
	@Override
	public void insert(Menu m) throws Exception{
		return;
	}
	@Override
	public void delete(Integer i) throws Exception{
		return;
	}
	@Override
	public Menu select(Integer i) throws Exception{
		return null;
	}
    @Override
    public ArrayList<Menu> selectAll() throws Exception {
    	ArrayList<Menu> list = new ArrayList<Menu>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
 
        try {
            con = getConnection();
            pstmt = con.prepareStatement("SELECT * FROM MENU");
            rset = pstmt.executeQuery();
            while (rset.next()) {
                String name = rset.getString("NAME");
                int price = rset.getInt("PRICE");
 
                Menu m = new Menu(name, price);
                list.add(m);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
        return list;
    }
	@Override
	public void deleteM(Menu m) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(
					"DELETE FROM MENU WHERE NAME=?");		
			pstmt.setString(1, m.getMenu());
			int result = pstmt.executeUpdate();
			if(result == 0) {
				throw new Exception();
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}
}
