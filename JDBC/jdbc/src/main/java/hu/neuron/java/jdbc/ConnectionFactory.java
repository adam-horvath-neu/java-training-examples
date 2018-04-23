package hu.neuron.java.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static Properties properties;

	public static synchronized Connection getConnection() throws SQLException {
		if (properties == null) {
			properties = new Properties();
			try {
				properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (properties != null) {
			Connection conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("password"));
			return conn;
		}
		throw new RuntimeException("Connection error");
	}
}
