package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import frame.Dao;
import frame.Sql;
import vo.Item;
import vo.User;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(Connection con, User v) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.userInsert);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally { //예외나더라도 close는 꼭해야 > finally
			close(pstmt);
		}
		
	}

	@Override
	public void delete(Connection con, String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Connection con, User v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User select(Connection con, String k) throws Exception {
		User u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = con.prepareStatement(Sql.userSelect);
			pstmt.setString(1, k);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD");
				String name = rset.getString("NAME");
				u = new User(id, pwd, name);
			}
			if(u == null)
                throw new Exception();
		}catch(Exception e){
			throw e;
		}finally {
			close(pstmt);
		}
		return u;
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		ArrayList<User> list = new ArrayList<User>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        try {
			pstmt = con.prepareStatement(Sql.userSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD");
				String name = rset.getString("NAME");
				User i = new User(id, pwd, name);
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
