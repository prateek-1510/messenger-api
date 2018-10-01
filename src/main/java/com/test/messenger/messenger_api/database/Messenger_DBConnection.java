package com.test.messenger.messenger_api.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Messenger_DBConnection {
	private static Connection con;
	public static Connection getDBConnection() {
		try {
			System.out.println("before");
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Properties properties = new Properties();
			String resourceName = "database.properties";
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream(resourceName);
			properties.load(resourceStream);
			System.out.println("after");
			con = DriverManager.getConnection(properties.getProperty("connectionurl"),
					properties.getProperty("user"),
					properties.getProperty("password"));
			System.out.println("connection success");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

}
