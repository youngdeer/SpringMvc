package org.swinglife.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	public static final String url = "jdbc:mysql://127.0.0.1/transaction";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "root";  
    
    public Connection getConnection() throws SQLException{
    	try {
			Class.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//指定连接类型 
		return DriverManager.getConnection(url, user, password);
    }
    
    public static void main(String[] args) throws SQLException{
    	DataSource ds = new DataSource();
    	ds.getConnection();
    }
}
