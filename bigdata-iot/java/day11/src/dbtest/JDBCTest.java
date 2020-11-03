package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class JDBCTest {

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
		String sql = "SELECT * FROM USERS"; //여기선 세미콜론 안해도됨
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 4. Result - ResultSet
		ResultSet rset = null;
		ArrayList<User> list = new ArrayList<>();
		try {
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String id = rset.getNString("ID");
				String pwd = rset.getNString("PWD");
				String name = rset.getNString("NAME");
				User user = new User(id, pwd, name);
				list.add(user);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 5. Close
		try {
			rset.close();
			pstmt.close();
			con.close();
			System.out.println("closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(User u:list)
			System.out.println(u);
		
	}

}
