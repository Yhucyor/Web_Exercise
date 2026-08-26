package thuc.ute.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionMySQL {

	private final String serverName = "localhost";
	private final String dbName = "LoginExerciseDB";
	private final String portNumber = "3306";
	private final String userID = "root";
	private final String password = "123456";

	public Connection getConnection() throws Exception {

		String url = "jdbc:mysql://" + serverName + ":" + portNumber
				+ "/" + dbName
				+ "?useSSL=false"
				+ "&serverTimezone=UTC"
				+ "&allowPublicKeyRetrieval=true";

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(url, userID, password);
	}

}