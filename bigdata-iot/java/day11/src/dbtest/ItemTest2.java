package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemTest2 {

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
		String sql = "UPDATE ITEMS SET NAME=?,PRICE=? WHERE ID=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "BEER");
			pstmt.setInt(2, 1515);
			pstmt.setString(3, "it03");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 4. Result - ResultSet
		int result = 0;
		try {
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 5. Close
		try {
			pstmt.close();
			con.close();
			System.out.println("closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
