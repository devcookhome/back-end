package com.devcookhome.model;

import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@javax.persistence.Entity(name = "ingredient")
public class Ingredient{
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@ManyToMany()
	@JoinTable(
        name = "ingredient_type", 
        joinColumns = { @JoinColumn(name = "ingredient_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "type_id") }
    )
	private List<Type> type;

	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}
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