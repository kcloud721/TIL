package w0724;

import java.util.ArrayList;

public class UserDb extends Db<String,User> {
	
	
	public UserDb() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDb(String ip, int port) {
		super(ip, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(User v) throws Exception {
		connect();
		if(v.getId().equals("serom")) {
			close();
			//throw new Exception("Duplicated ID..");
		}
		System.out.println("INSERTED: "+v);
		close();
		}

	@Override
	public void update(User v) throws Exception {
		connect();
		System.out.println("UPDATED: "+v);
		close();
		}

	@Override
	public void delete(String k) throws Exception {
		connect();
		System.out.println("DELETED: "+k);
		close();
		}

	@Override
	public User select(String k) throws Exception {
		User user = null;
		//k값을 이용해서 사용자 정보를 검색한다.
		user = new User("id99", "pwd90", "이말숙");
		return user;
	}

	@Override
	public ArrayList<User> select() throws Exception {
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "이"));
		list.add(new User("id02", "pwd02", "정"));
		list.add(new User("id03", "pwd03", "김"));
		list.add(new User("id04", "pwd04", "한"));
		list.add(new User("id05", "pwd06", "박"));
		return list;
	}

	

	
}
