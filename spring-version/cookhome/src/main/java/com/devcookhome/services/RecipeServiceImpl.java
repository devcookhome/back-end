package com.devcookhome.services;

import com.devcookhome.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.devcookhome.dao.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
  	private RecipeRepository repository;	

    public List<Recipe> findAll(){
        return repository.findAll(sortByIdDesc());
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

    private Sort sortByIdDesc() {
      return Sort.by(Sort.Direction.DESC, "id");
  }

}