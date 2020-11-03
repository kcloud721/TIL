package controller;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ItemDao;
import frame.Controller;
import frame.Dao;
import vo.Item;

public class ItemController extends Controller<String, Item> {
	
	Dao<String, Item> dao;
	
	public ItemController()
	{
		dao = new ItemDao();
	}
	
	@Override
	public void register(Item v) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.insert(con, v);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally{
			close(con);
		}
	}

	@Override
	public void remove(String k) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.delete(con, k);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally{
			close(con);
		}
	}

	@Override
	public void modify(Item v) throws Exception {
		Connection con = null;
		try {
			con = getConnection();
			dao.update(con, v);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally{
			close(con);
		}
	}

	@Override
	public Item get(String k) throws Exception {
		Connection con = null;
		Item i = null;
		try {
			con = getConnection();
			i = dao.select(con, k);
			//con.commit();
			// SELECT는 걍 조회하는거라 트랜잭션 관리 필요 없음
		}catch(Exception e) {
			//con.rollback();
			throw e;
		}finally{
			close(con);
		}
		return i;
	}

	@Override
	public ArrayList<Item> get() throws Exception {
		ArrayList<Item> list = new ArrayList<Item>();
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
