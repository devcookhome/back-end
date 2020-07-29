package com.devcookhome.model;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity(name = "group1")
public class Group extends Entity{

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}	
	
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

