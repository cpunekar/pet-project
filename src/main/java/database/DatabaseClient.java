package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseClient {
	private static DatabaseClient instance;
	private Connection connection;
	private String sqlPort = "3306";
	private String dbName = "pet_store";
	
	private String dbConnURL = "jdbc:mysql://localhost:" + sqlPort + "/" + dbName
			+ "?useLegacyDatetimeCode=false&serverTimezone=America/New_York&useSSL=false";
	
	private DatabaseClient() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(dbConnURL, "root", "Nedved@10");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.printf("Failed to create the database connection", e);
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static DatabaseClient getInstance() {
		if (instance == null) {
			instance = new DatabaseClient();
		} else
			try {
				if (instance.getConnection().isClosed()) {
					instance = new DatabaseClient();
				}
			} catch (SQLException e) {
				System.out.printf("Failed to get the database client instance", e);
			}
		return instance;
	}
}


