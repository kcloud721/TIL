package com.component;

import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Service;
import com.vo.User;

public class UserService implements Service<String, User> {

	Dao<String,User> dao;
	
	public void setDao(Dao<String,User> dao) {
		this.dao = dao;
	}
	
	@Override
	public void register(User v) {
		dao.insert(v);
	}

	@Override
	public void remove(String k) {
		dao.delete(k);
	}

	@Override
	public void modify(User v) {
		dao.update(v);
	}

	@Override
	public User get(String k) {
		return (User) dao.select(k);
	}

	@Override
	public ArrayList<User> get() {
		return dao.select();
	}

}
