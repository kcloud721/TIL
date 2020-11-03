package frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Data Access Object
public abstract class Dao<K,V> {
	public void close(ResultSet rset) {
		if(rset != null) {
			try {
				rset.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	public void close(PreparedStatement pstmt) {
		
	}
	
	public abstract void insert(Connection con, V v) throws Exception;
	public abstract void delete(Connection con, K k) throws Exception;
	public abstract void update(Connection con, V v) throws Exception;
	public abstract V select(Connection con, K k) throws Exception;
	public abstract ArrayList<V> select(Connection con) throws Exception;
	
	
	
}
