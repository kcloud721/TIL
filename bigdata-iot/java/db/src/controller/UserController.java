package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDao;
import frame.Controller;
import frame.Dao;
import vo.User;

public class UserController extends Controller<String, User> {
	
	Dao<String, User> dao;
	
	public UserController() {
		dao = new UserDao();
	}
	
	@Override
	public void register(User v) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.insert(con, v);
			con.commit(); //정상처리시 커밋
		}catch(Exception e){
			con.rollback(); //문제시 롤백
			throw e;
		}finally {
			close(con);
		}
	}

	@Override
	public void remove(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(User v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
