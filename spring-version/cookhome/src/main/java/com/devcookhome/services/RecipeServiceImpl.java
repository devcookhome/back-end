package com.devcookhome.services;

import com.devcookhome.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import com.devcookhome.dao.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
  	private RecipeRepository repository;	

    public Iterable<Recipe> findAll(){
        return repository.findAll();
    }

    public Recipe save(Recipe recipe){
    	return repository.save(recipe);
    }

    public Recipe findById(Long id){
    	return repository.findById(id).get();
    }

    public void delete(Recipe recipe){
      repository.delete(recipe);
    }
}