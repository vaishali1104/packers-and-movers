package com.KS.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

public class DbConnection {
	
	private static final String urlName = "jdbc:mysql://localhost:3306/packersAndMovers";
	private static final String driverClass = "com.mysql.jdbc.Driver";
	private static final String userName = "root";
	private static final String password = "royal";
	public static Connection getConnection() throws IOException {
		/*Properties prop = new Properties();

		FileInputStream fin = new FileInputStream("dbconfig.properties");

		prop.load(fin);

		String userName = prop.getProperty("userName").trim();
		String password = prop.getProperty("password").trim();
		String urlName = prop.getProperty("urlName").trim();
		String driverClass = prop.getProperty("driverClass").trim();
*/
		
		Connection conn = null;

		try {
			Class.forName(driverClass);

			conn = DriverManager.getConnection(urlName, userName, password);

		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
