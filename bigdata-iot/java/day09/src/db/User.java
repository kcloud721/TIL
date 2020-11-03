package db;

public class User { // class User "extends Object" : 생략되어있음 
					// > User는 Object 에 상속되어있음
	private String id;
	private String pwd;
	private String name;
	
	public User() {
	}

	public User(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setpwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
	}
	
	
	
}
