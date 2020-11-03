package com.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Db;
import com.frame.Sql;
import com.vo.Menu;

public class MenuDb extends Db<String, Menu> {
	public MenuDb() {
	}

	public MenuDb(String dbid, String dbpwd) {
		super(dbid, dbpwd);
	}

	@Override
	public void update(Menu menu) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("UPDATE MENU SET PRICE=? WHERE NAME=?");
			pstmt.setInt(1, menu.getPrice());
			pstmt.setString(2, menu.getMenu());

			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void insert(Menu m) throws Exception {
		Connection con = null;
		con = getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement("INSERT INTO MENU VALUES(?,?)");
			psmt.setString(1, m.getMenu());
			psmt.setInt(2, m.getPrice());
			psmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(psmt);
			close(con);
		}
	}

	@Override
	public void delete(String i) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("DELETE FROM MENU WHERE NAME=?");
			pstmt.setString(1, i);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public Menu select(String i) throws Exception {
		Menu me = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement("SELECT * FROM MENU WHERE NAME=?");
			pstmt.setString(1, i);
			
			rset = pstmt.executeQuery();
			rset.next();
			
			String menu = rset.getString("NAME");
			int price = rset.getInt("PRICE");
			me = new Menu(menu, price);
			
		} catch (Exception e) {
			throw e;
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		return me;
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
}
