package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDao;
import dao.UserItemDao;
import frame.Controller;
import frame.Dao;
import vo.User;
import vo.UserItem;

public class UserController extends Controller<String, User> {
	
	Dao<String, User> dao;
	UserItemDao uidao;
	
	public UserController() {
		dao = new UserDao();
		uidao = new UserItemDao();
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
		User user = null;
		Connection con = null;
		ArrayList<UserItem> list = null;
		try {
			con = getConnection();
			user = dao.select(con, k);
			list = uidao.getItems(con, k);
			user.setUserItems(list);
			//ㅈㄴ헷갈리는부분
			
		}catch(Exception e) {
			throw e;
		}finally{
			close(con);
		}
		return user;
	}

	@Override
	public ArrayList<User> get() throws Exception {
		ArrayList<User> list = new ArrayList<User>();
		Connection con = null;
		try {
			con = getConnection();
			list = dao.select(con);
		}catch(Exception e) {
			throw e;
		}finally{
			close(con);
		}
		return list;
	}
	
	
	
}
