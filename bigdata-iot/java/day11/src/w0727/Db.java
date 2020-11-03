package w0727;

import java.sql.*;
import java.util.ArrayList;

public abstract class Db<K, V> {
    private String url;
    private String dbid;
    private String dbpwd;

    public Db() {
    }
    public Db(String dbid, String dbpwd) {
        // 1. Driver Loading
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) { e.printStackTrace(); }
        this.url = "jdbc:oracle:thin:@192.168.0.26:1521:xe";
        this.dbid = dbid;
        this.dbpwd = dbpwd;
    }

    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, dbid, dbpwd);
        } catch (SQLException e) { e.printStackTrace(); }
        return con;
    }
    public void close(ResultSet rset){
        if (rset != null){try{rset.close();} catch (SQLException e){e.printStackTrace();}}
    }
    public void close(PreparedStatement psmt){
        if (psmt != null){try{psmt.close();} catch (SQLException e){e.printStackTrace();}}
    }
    public void close(Connection con){
        if (con != null){try{con.close();} catch (SQLException e){e.printStackTrace();}}
    }
    abstract public void insert(V v) throws Exception;
    abstract public void delete(K k) throws Exception;
    abstract public void update(V v) throws Exception;
    abstract public V select(K k) throws Exception;
    abstract public ArrayList<V> select() throws Exception;
}