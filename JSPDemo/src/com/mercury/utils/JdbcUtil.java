package com.mercury.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
	
	// for connecting to DB by using JDBC
	// need below 4 informations:
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "ggao";
	private static final String PASSWORD = "mercury";
	
	public static Connection getConnection(){
		Connection conn = null;
		try{
			// Class.forName() will load the class into Perm Gen during runtime
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(Exception e){
			System.err.println(e);
		}
		return conn;
	}
	
}