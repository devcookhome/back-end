package com.devcookhome.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;

@javax.persistence.Entity(name = "direction")
public class Direction{

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Integer time;
	@Column(nullable = false)
	private String timeUnity;
	@Column(nullable = false)
	private String description;

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setTime(Integer time){
		this.time = time;
	}
	public Integer getTime(){
		return this.time;
	}

	public void timeUnity(String timeUnity){
		this.timeUnity = timeUnity;
	}
	public String getTimeUnity(){
		return this.timeUnity;
	}

	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}
}