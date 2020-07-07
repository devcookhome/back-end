package com.devcookhome.model;

public abstract class Entity{
	
	private Long id;
	public abstract String getFieldName(); 
	public abstract String getTableName();


	
	public String getFieldValue(){

		if(this instanceof Group){
			return ((Group)this).getName();
		}
		return ((Type)this).getType(); 
	}
	
	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setFieldValue(String value){

		if(this instanceof Group){
			((Group)this).setName(value);
	 	}else{
		 	((Type)this).setType(value); 
	 	}
	}
}

