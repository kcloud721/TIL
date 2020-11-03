package db2;

//import db2.Db;
//import db2.OracleDbImpl;
//import db2.MariaDbImpl;

public class App {

	public static void main(String[] args) {
		//Db db = new Db; //Db 는 추상클래스라 생성불가
		Db db = new OracleDbImpl("192.168.99.99", 99);
		db.insert();
		//db.찍어보면 connect, close 보여
		//protected로 encapsulation 해도 보임 > 같은 패키지에선 보이기 때문
		//패키지 다르게 db2.app 만들고 import하면 db.찍어도 안보임
		System.out.println();
		
		Db dbO = new MariaDbImpl();
		dbO.insert();
		if(db instanceof OracleDbImpl) {
			((OracleDbImpl)db).search();
		} else if(db instanceof MariaDbImpl) {
			((OracleDbImpl)db).search();
		}
		
		
	}

}
