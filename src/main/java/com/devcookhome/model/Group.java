package com.devcookhome.model;

public class Group extends Entity{
	
	private String name;
	
	public String getFieldName(){

		return "name";
	}

	public String getTableName(){

		return "group1";
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
}

