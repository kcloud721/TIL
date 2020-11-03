package com.biz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import com.frame.Db;
import com.vo.Table;

public class TableDb extends Db<Integer, Table> {
	public TableDb() {}
	public TableDb(String dbid, String dbpwd) {
		super(dbid, dbpwd);
	}
	@Override
    public void insert(Table table) throws Exception {
    	Connection con = null;
        con = getConnection();
        PreparedStatement psmt = null;
        try{
            psmt = con.prepareStatement("INSERT INTO DINNINGTABLE VALUES(?,?)");
            psmt.setInt(1,table.getTableNo());
            psmt.setString(2,table.getMenus());
            psmt.executeUpdate();
        }
        catch (Exception e){
            throw e;
        }
        finally {
            close(psmt);
            close(con);
        }
	}
    @Override
    public void delete(Integer integer) throws Exception {
    	Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement("DELETE FROM DINNINGTABLE WHERE TABLENO=?");		
			pstmt.setInt(1, integer);
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
    public Table select(Integer integer) throws Exception {
		Table p = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        ArrayList<String> menuList = new ArrayList<String>();
         try {
            con = getConnection();
            pstmt = con.prepareStatement("SELECT * FROM DINNINGTABLE WHERE TABLENO=?");
            pstmt.setLong(1, integer);
            rset = pstmt.executeQuery();
            while (rset.next()) {
                int tableno = rset.getInt("TABLENO");
                String ordered = rset.getString("ORDERED");
                
                String[] menuArr = ordered.split(" ");
                for(int i=0 ; i<menuArr.length ; i++) {
                	menuList.add(menuArr[i]); 
                	System.out.println(menuList.get(i));
                }
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
	public void update(Table t) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;	
		try {
			con = getConnection();
			pstmt = con.prepareStatement("UPDATE DINNINGTABLE SET ORDERED=? WHERE TABLENO=?");
			pstmt.setString(1, t.getMenus());
			pstmt.setInt(2, t.getTableNo());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}
	@Override
    public ArrayList<Table> selectAll() throws Exception {
    	ArrayList<Table> list = new ArrayList<Table>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
 
        try {
            con = getConnection();
            pstmt = con.prepareStatement("SELECT * FROM DINNINGTABLE");
            rset = pstmt.executeQuery();
            while (rset.next()) {
                
                int tableno = rset.getInt("TABLENO");
                String menus = rset.getString("ORDERED");
                Table t = new Table(tableno, menus);
                list.add(t);
                
                
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
	public void deleteM(Table t) throws Exception {
    	Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(
					"DELETE FROM MENU WHERE NAME=?");		
			pstmt.setString(1, t.getMenus());
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
