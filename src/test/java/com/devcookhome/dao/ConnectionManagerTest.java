package com.devcookhome.dao;

public class ConnectionManagerTest{

	
	public static void main(String[] args) {
	
		System.out.print("ConnectionManagerTest#getInstance");

		ConnectionManager cm = ConnectionManager.getInstance();
		assert cm != null;

		System.out.println("... OK");
		

	}
}