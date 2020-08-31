package com.devcookhome.model;

public class RecipeIngredient{

	private String qtd;
	private Ingredient ingredient;

	public void setQtd(String qtd){
		this.qtd = qtd;
	}
	public String getQtd(){
		return this.qtd;
	}

	public void setIngredient(Ingredient ingredient){
		this.ingredient = ingredient;
	}
	public Ingredient getIngredient(){
		return this.ingredient;
	}



}