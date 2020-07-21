package com.devcookhome.model;

public class Type extends Entity{

	private String type;

	public String getFieldName(){

		return "type";
	}

	public String getTableName(){

		return "type";
	}


	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}
}