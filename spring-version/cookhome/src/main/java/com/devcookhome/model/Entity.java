package com.devcookhome.model;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public abstract class Entity{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(nullable = false)
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

