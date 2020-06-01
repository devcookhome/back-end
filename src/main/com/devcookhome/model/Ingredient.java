package com.devcookhome.model;

import java.util.List;

public class Ingredient{
	
	private String name;
	private List<Type> type;

	public void setName (String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setType(List<Type> type){
		this.type = type;
	}

	public List<Type> getType(){
		return this.type;
	}
}	