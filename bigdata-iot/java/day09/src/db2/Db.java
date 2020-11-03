package db2;

import db.User;

//추상클래스 > 객체를 만들 수 없음
public abstract class Db {
	protected String ip;
	protected int port;
	public Db() {
		
	}
	public Db(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	//public으로 하니까 App에서 db.찍으면 함수 볼 수 있어.
	//보안 취약 > private 또는 protected
	protected void connect() {
		System.out.println("["+ip+"]"+ "Connected");
	}
	protected void close() {
		System.out.println("["+ip+"]"+ "Closed");		
	}
	public abstract void insert(/*Object o*/); //Object는 뭐든지 들어갈 수 있음.. 
										//클래스 선언 시 extends Object 생략되어있는 상태라 가능
										// Object o = new User 가능
	public abstract void delete();
	public abstract void update();
	public abstract void select();
	public abstract void selectAll();
	
	
}


