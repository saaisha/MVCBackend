package com.saaisha.connection;

import java.sql.*;

public class DBconnection {

	
	static Connection conn= null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public static Connection getMysqlConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn= DriverManager.getConnection("jdbc:mysql://localhost/Sports", "root", "nimatgill");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
