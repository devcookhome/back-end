package com.devcookhome.model;

public class RecipeIngredient{

	private Long id;
	private String recipeIngredient;

	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return this.id;
	}

	public void setRecipeIngredient(String recipeIngredient){
		this.recipeIngredient = recipeIngredient;
	}
	public String getRecipeIngredient(){
		return this.recipeIngredient;
	}
}