package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
