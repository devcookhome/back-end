package com.devcookhome.dao;

public class ConnectionManagerTest{

	
	public static void main(String[] args) {
	
		System.out.println("ConnectionManagerTest#getInstance");

		ConnectionManager cm = ConnectionManager.getInstance();
		assert cm != null;
		

	}
}