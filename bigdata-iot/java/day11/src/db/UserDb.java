package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDb extends Db<String, User> {

		
	public UserDb() {
		super();
	}

	public UserDb(String ip, String dbid, String dbpwd) {
		super(ip, dbid, dbpwd);
	}

	@Override
	public void insert(User v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.userInsert);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}

	}

	@Override
	public void delete(String k) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.userDelete);		
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();
			//없는 값  delete해도 예외처리가 되지 않음
			//executeUpdate의 반환값 활용하여 조건문으로 예외처리
			if(result == 0) {
				throw new Exception(); //강제로 예외 발생시킴 
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}	
	}

	@Override
	public void update(User v) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.userUpdate);		
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getId());
			int result = pstmt.executeUpdate();
			if(result == 0) {
				throw new Exception(); //강제로 예외 발생시킴 
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public User select(String k) throws Exception {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.userSelect);
			pstmt.setString(1, k);
			rset = pstmt.executeQuery();
			rset.next();
			String id = rset.getString("ID");
			String pwd = rset.getString("PWD");
			String name = rset.getString("NAME");
			user = new User(id, pwd, name);		
		} catch(Exception e) {
			throw e;
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		
		return user;
	}

	@Override
	public ArrayList<User> select() throws Exception {
		ArrayList<User> list = new ArrayList<User>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Sql.userSelectAll);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String id = rset.getString("ID");
				String pwd = rset.getString("PWD");
				String name = rset.getString("NAME");
				User user = new User(id, pwd, name);
				list.add(user);
			}
		} catch(Exception e) {
			throw e;
		} finally {
			close(rset);
			close(pstmt);
			close(con);
		}
		return list;
	}
}
