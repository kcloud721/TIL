package com.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Db;
import com.frame.Sql;
import com.vo.Table;

public class TableDb extends Db<Integer, Table> {

	public TableDb() {
		super();
	}

	public TableDb(String dbid, String dbpwd) {
		super(dbid, dbpwd);
	}
	
	public TableDb(String ip, String dbid, String dbpwd) {
		super(ip, dbid, dbpwd);
	}

	@Override
	public void insert(Table v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer integer) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Table v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.tableUpdate);		
			pstmt.setNString(1, v.getMenu());
			pstmt.setInt(2, v.getTableno());
			pstmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
    public Table select(Integer integer) throws Exception {
		Table p = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
 
        try {
            con = getConnection();
            pstmt = con.prepareStatement(
            		"SELECT * FROM DINNINGTABLE WHERE TABLENO=?");
            pstmt.setLong(1, integer);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                int tableno = rset.getInt("TABLENO");
                String ordered = rset.getString("ORDERED");
                p = new Table(tableno, ordered);
            }
            if (p == null)
                throw new Exception();
        } catch (Exception e) {
            System.out.println("no such component");
            throw e;
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
        return p;
    }

	@Override
	public ArrayList<String> selectM(Integer integer) throws Exception {
		ArrayList<String> orderedList = new ArrayList<String>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(
            		"SELECT * FROM DINNINGTABLE WHERE TABLENO=?");
            pstmt.setLong(1, integer);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                String menus = rset.getString("ORDERED");
                
                String[] menuArr = menus.split(" ");
                for(int i=0 ; i<menuArr.length ; i++) {
                	orderedList.add(menuArr[i]); 
                	System.out.println(orderedList.get(i));
                }
                //orderedList.add(menus);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
		return orderedList;
	}

	@Override
	public int getMenuPrice(Table v) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
