package com.devcookhome.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.devcookhome.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
