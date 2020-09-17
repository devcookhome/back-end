package com.devcookhome.model;

public class User{

	private String email;
	private String username;
	private String name;

	public void setEmail(String email){
		this.email = email;
	}

	public void getEmail(){
		return this.email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public void getUsername(){
		return this.username;
	}

	public void setName(String name){
		this.name = name;
	}

	public void getName(){
		return this.name;
	}
}