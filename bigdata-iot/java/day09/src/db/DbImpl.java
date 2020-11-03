package db;

public class DbImpl {
	private String ip;
	private int port;
	public DbImpl() {
	}
	public DbImpl(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	private void connect() {
		System.out.println("connected " + ip);
	}
	private void close() {
		System.out.println("close "+ip);
	}
	
	
	public void insert(User u) {
		connect();
		System.out.println("Inserted: "+u.getId()+" "+u.getPwd()+" " +u.getName());
		close();
	}
	
	public void delete(String id) {
		System.out.println("Deleted: "+id);
	}
	
	public void update(User u) {
		System.out.println("Updated: "+u.getId()+" "+u.getPwd()+" "+u.getName());
	}
	
	public User select(String id) {
		connect();
		System.out.println("Selected: "+id);
		User user = new User(id, "pwd01", "Lee");
		close();
		return user; //리턴은 항상 마지막에
	}
	
	public User[] select() {
		User[] users = new User[3];
		users[0] = new User("id01", "pwd01", "Kim");
		users[1] = new User("id02", "pwd02", "Tae");
		users[2] = new User("id03", "pwd03", "Seo");
		return users;
	}
	
}
