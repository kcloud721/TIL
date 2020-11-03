package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemTest1 {

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
		String sql = "INSERT INTO ITEMS VALUES(?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "it03");
			pstmt.setString(2, "CUP");
			pstmt.setInt(3, 4500);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 4. Result - ResultSet
		ResultSet rset = null;
		ArrayList<Item> list = new ArrayList<>();
		try {
			rset = pstmt.executeQuery();
//			while(rset.next()) {
//				String id = rset.getNString("ID");
//				String name = rset.getNString("NAME");
//				int price = rset.getInt("PRICE");
//				Item item = new Item(id, name, price);
//				list.add(item);
//			}
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
		
		for(Item i:list)
			System.out.println(i);
		
	}

}
