package com.frame;

public class Sql {
	public static String userInsert=
			"INSERT INTO DINNINGTABLE VALUES(?,?,?)";
	//객체 ?��?�� ?��?��?�� ?��?��?
	public static String userDelete=
			"DELETE FROM DINNINGTABLE WHERE ID=?";
	public static String userUpdate=
			"UPDATE DINNINGTABLE SET MENUS=? WHERE TABLENO=?";
	public static String DINNINGTABLEelect=
			"SELECT * FROM DINNINGTABLE WHERE ID=?";
	public static String DINNINGTABLEelectAll = 
			"SELECT * FROM DINNINGTABLE";
}
