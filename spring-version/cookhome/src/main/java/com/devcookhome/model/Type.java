package com.devcookhome.model;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity(name = "type")
public class Type extends Entity{

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String type;
	
	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

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