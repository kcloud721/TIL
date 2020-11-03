package db;

public class Sql {
	public static String userInsert=
			"INSERT INTO USERS VALUES(?,?,?)";
	//객체 생성 안해도 된다?
	public static String userDelete=
			"DELETE FROM USERS WHERE ID=?";
	public static String userUpdate=
			"UPDATE USERS SET PWD=?,NAME=? WHERE ID=?";
	public static String userSelect=
			"SELECT * FROM USERS WHERE ID=?";
	public static String userSelectAll = 
			"SELECT * FROM USERS";
}
