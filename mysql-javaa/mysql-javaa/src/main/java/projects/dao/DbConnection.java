package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	//create constants to the correct values
	private static String HOST = "localhost";
	private static String PASSWORD = "projects";
	private static int PORT = 3306;
	private static String SCHEMA = "projects";
	private static String USER = "projects";
	
	//create method named getConnection()
	public static Connection getConnection() {
		// create String variable name URL contains mySQL connection URL
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA,
				USER,PASSWORD);
		System.out.println("Connecting with url=" + url);
		
		// call DriverManager(class in JDBC library) to obtain a connection
				// surround call to DriverManager.getConnection() w/ a try/catch block
						// catch block should catch SQLException
		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Projects connection is succesful!");
			return conn;
		} catch (SQLException e) {
			System.out.println("Connection failed");
			throw new DbException(e);
		}
				
			}
	
}
