package com.devcookhome.model;

public class Type{

	private Long id;
	private String type;

	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}

	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}
}