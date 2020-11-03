package com.biz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Db;
import com.vo.Product;

public class ProductDb extends Db<Integer, Product> {
    public ProductDb() {
    }
	public ProductDb(String ip, String dbid, String dbpwd) {
		super(ip, dbid, dbpwd);
	}

    @Override
    public void insert(Product product) throws Exception {
    }

    @Override
    public void delete(Integer integer) throws Exception {
    	Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement("DELETE FROM PRODUCT WHERE=?");        
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
    public void update(Product product) throws Exception {
    	Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(
					"UPDATE DINNINGTABLE SET MENU=? WHERE TABLENO=?");		
					//"UPDATE PRODUCT SET NAME=?, PRICE=?, RATE=? WHERE ID=?");		
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
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
    public Product select(Integer integer) throws Exception {
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rset = null;
    	Product p = null;
    	try {
    		con = getConnection();
    		pstmt = con.prepareStatement(
    				"SELECT * FROM PRODUCT WHERE ID=?");
    		pstmt.setInt(1, integer);
    		rset = pstmt.executeQuery();
    		rset.next();
    		int id = rset.getInt("ID");
    		String name = rset.getNString("NAME");
    		int price = rset.getInt("PRICE");
    		double rate = rset.getDouble("RATE");
    		Date regdate = rset.getDate("REGDATE");
    		p = new Product(id,name,price,rate,regdate);
    	}catch (Exception e) {
    		throw e;
    	} finally {
    		close(con);
    		close(pstmt);
    		close(rset);
    	}
        return p;
    }
    @Override
    public ArrayList<Product> select() throws Exception {
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	ResultSet rset = null;
    	ArrayList<Product> list = new ArrayList<Product>();
    	try {
    		con = getConnection();
    		pstmt = con.prepareStatement(
    				"SELECT * FROM PRODUCT");
    		rset = pstmt.executeQuery();
    		while(rset.next()) {
    			int id = rset.getInt("ID");
        		String name = rset.getNString("NAME");
        		int price = rset.getInt("PRICE");
        		double rate = rset.getDouble("RATE");
        		Date regdate = rset.getDate("REGDATE");
        		Product p = new Product(id,name,price,rate,regdate);
        		list.add(p);
    		}
    	}catch (Exception e) {
    		throw e;
    	}finally {
			close(rset);
			close(pstmt);
			close(con);
		}
        return list;
    }

}