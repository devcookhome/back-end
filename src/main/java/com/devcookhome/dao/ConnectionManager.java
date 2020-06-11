package com.devcookhome.dao;

public class ConnectionManager{

	private static ConnectionManager instance;

	private ConnectionManager(){


	}
	public static ConnectionManager getInstance(){

		if(instance == null){

			instance = new ConnectionManager();
		}

		return instance;
	}
}