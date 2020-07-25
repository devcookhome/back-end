package com.devcookhome.model;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity(name = "group1")
public class Group extends Entity{
	
	@Column(nullable = false)
	private String name;
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
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

