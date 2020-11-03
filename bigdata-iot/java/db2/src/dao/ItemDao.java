package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;


import frame.Dao;
import frame.Sql;
import vo.Item;

public class ItemDao extends Dao<String, Item> {

	@Override
	public void insert(Connection con, Item v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.itemInsert);
			pstmt.setString(1, v.getName());
			pstmt.setInt(2, v.getPrice());
			int result = pstmt.executeUpdate();
			if(result == 0)
				throw new Exception();
		}catch(Exception e){
			throw e;
		}finally {
			close(pstmt);
		}
	}

	@Override
	public void delete(Connection con, String k) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.itemDelete);
			pstmt.setString(1, k);
			pstmt.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally {
			close(pstmt);
		}
		
	}

	@Override
	public void update(Connection con, Item v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.itemUpdate);
			pstmt.setString(1, v.getName());
			pstmt.setInt(2, v.getPrice());
			pstmt.setInt(3, v.getId());
			int result = pstmt.executeUpdate();
			if(result == 0)
				throw new Exception();
		}catch(Exception e){
			throw e;
		}finally {
			close(pstmt);
		}
		
	}

	@Override
	public Item select(Connection con, String k) throws Exception {
		Item it = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = con.prepareStatement(Sql.itemSelect);
			pstmt.setString(1, k);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int id = rset.getInt("ID");
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				Date d = rset.getDate("REGDATE");
				it = new Item(id, name, price, d);
			}
			if(it == null)
                throw new Exception();
		}catch(Exception e){
			throw e;
		}finally {
			close(pstmt);
		}
		return it;
	}

	@Override
	public ArrayList<Item> select(Connection con) throws Exception {
    	ArrayList<Item> list = new ArrayList<Item>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        try {
			pstmt = con.prepareStatement(Sql.itemSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				int id = rset.getInt("ID");
				String name = rset.getString("NAME");
				int price = rset.getInt("PRICE");
				Date d = rset.getDate("REGDATE");
				Item i = new Item(id, name, price, d);
				list.add(i);
			}
		}catch(Exception e){
			throw e;
		}finally {
			close(pstmt);
		}
		return list;
	}

}
