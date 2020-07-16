package com.devcookhome.model;

import java.util.List;

public class Recipe{

	private String name;
	private List<Direction> directions;
	private Portion portion;
	private List<RecipeIngredient> ingredients;

	public void setName(String name){
		this.name = name;
	}
 	
	public String getName(){
 		return this.name;
 	}

 	public void setDirections(List<Direction> directions){
 		this.directions = directions;
 	}

 	public List<Direction> getDirections(){
 		return this.directions;
 	}

 	public void setPortion(Portion portion){
 		this.portion = portion;
 	}

 	public Portion getPortion(){
 		return this.portion;
 	}

	public void setIngredients(List<RecipeIngredient> ingredients){
		this.ingredients = ingredients;
	}

	public List<RecipeIngredient> getIngredients(){
		return this.ingredients;
	}
}

