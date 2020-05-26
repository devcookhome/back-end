package com.devcookhome.model;

public class Direction{

	private String time;
	private String timeUnity;
	private String description;

	public void setTime(String time){
		this.time = time;
	}
	public String getTime(){
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