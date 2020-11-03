package w0724;

import java.util.ArrayList;

public abstract class Db<K,V> {
	protected String ip;
	protected int port;
	public Db() {
	}
	public Db(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public void connect() {
		System.out.println(ip+" Connection");
	}
	public void close() {
		System.out.println(ip+" Closed");		
	}
	
	//추상클래스는 하위에 있는걸 모두 포용할 수 있도록 설계
	abstract public void insert(V v) throws Exception;
	abstract public void update(V v) throws Exception;
	abstract public void delete(K k) throws Exception;
	abstract public V select(K k) throws Exception;
	abstract public ArrayList<V> select() throws Exception; 
	//select all이라 배열형태로 리턴받음
}
