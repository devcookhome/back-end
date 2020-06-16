package com.devcookhome.model;

public class Direction{

	private Integer time;
	private String timeUnity;
	private String description;

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