package com.tcs.register;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConn {
	public static Connection createConnection()
	{	
		Connection connection = null;
		try {
		Properties properties = new Properties();
		properties.load(new FileInputStream("E:\\javapractice\\AdvJavaProject\\src\\main\\webapp\\xyz.properties"));
		
		Class.forName(properties.getProperty("driver"));
		System.out.println("Driver Loaded successfully");
		connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
		System.out.println("Connection Created Successfully.....");
		}
		catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
	

