package com.devcookhome.model;

public class Ingredient{

	private String name;
	private String type;

	public void setName (String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}
}	