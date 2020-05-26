package com.devcookhome.model;

public class Recipe{

	private String name;
	private String directions;
	private String portion;
	private String ingredients;

	public void setName(){
		this.name = name;
	}
 	
	public String getName(){
 		return this.name;
 	}

 	public void setDirections(){
 		this.directions = directions;
 	}

 	public String getDirections(){
 		return this.directions;
 	}

 	public void setPortion(){
 		this.portion = portion;
 	}

 	public String getPortion(){
 		return this.portion;
 	}

	public void setIngredients(){
		this.ingredients = ingredients;
	}

	public String getIngredients(){
		return this.ingredients;
	}
}

