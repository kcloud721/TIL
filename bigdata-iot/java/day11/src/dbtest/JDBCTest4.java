package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class JDBCTest4 {

	public static void main(String[] args) {
		// JDBC Programming
		// 1. Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found!");
		}
		// 2. Connection
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbid = "db";
		String dbpwd = "db";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, dbid, dbpwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Not Connection !");
		}
		// 3. SQL - PreparedStatement
		String sql = "UPDATE USERS SET PWD=?,NAME=? WHERE ID=?"; //여기선 세미콜론 안해도됨
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "id@@");
			pstmt.setString(2, "수육");
			pstmt.setString(3, "id01");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 4. Result - ResultSet
		int result = 0;
		try {
			result = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			System.out.println("Duplicated ID");
			e1.printStackTrace();
		}
		System.out.println(result);
		// 5. Close
		try {
			pstmt.close();
			con.close();
			System.out.println("closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
