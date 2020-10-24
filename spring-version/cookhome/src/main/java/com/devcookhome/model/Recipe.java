package com.devcookhome.model;

import javax.persistence.Column;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@javax.persistence.Entity(name = "recipe")
public class Recipe {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	@OneToMany()
	@JoinColumn(name = "recipe_id")
	private List<Direction> directions;
	@OneToOne()
	@JoinColumn(name = "portion_id", referencedColumnName = "id")
	private Portion portion;
	@ManyToMany()
	@JoinTable(
        name = "recipe_ingredient", 
        joinColumns = { @JoinColumn(name = "recipe_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
	private List<Ingredient> ingredients;

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

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

	public void setIngredients(List<Ingredient> ingredients){
		this.ingredients = ingredients;
	}

	public List<Ingredient> getIngredients(){
		return this.ingredients;
	}
}

