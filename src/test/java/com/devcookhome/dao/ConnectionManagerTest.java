package com.devcookhome.dao;
import java.sql.Connection;

public class ConnectionManagerTest{

	
	public static void main(String[] args) {
	
		testGetInstance();
		testGetConnection();

	}

	public static void testGetInstance(){

		System.out.print("ConnectionManagerTest#getInstance");

		ConnectionManager cm = ConnectionManager.getInstance();
		assert cm != null;

		System.out.println("... OK");
	}


	public static void testGetConnection(){

		System.out.print("ConnectionManagerTest#getConnection");

		ConnectionManager cm = ConnectionManager.getInstance();
		Connection connection = cm.getConnection();
		assert connection != null;

		System.out.println("... OK");
	}
}