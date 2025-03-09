package com.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	public static Connection getSQLConnection() {
		Connection connection = null;

		// Register JDBC driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "test", "test");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
