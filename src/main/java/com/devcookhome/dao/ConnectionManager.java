package com.devcookhome.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager{

	private static ConnectionManager instance;
	private Connection connection;
	
	private ConnectionManager(){
	}
	
	public static ConnectionManager getInstance(){
		if(instance == null){
			instance = new ConnectionManager();
		}
		return instance;
	}

	public Connection getConnection(){
		if (connection == null) {
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Properties properties = new Properties();
				properties.setProperty("user", "root"); 
				properties.setProperty("password", "1234"); 
				properties.setProperty("MaxPooledStatements", "250"); 
				connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/dev_cookhome", properties);
			} catch (ClassNotFoundException | SQLException e){
				e.printStackTrace();
			}
		}
		return connection;
	}

}