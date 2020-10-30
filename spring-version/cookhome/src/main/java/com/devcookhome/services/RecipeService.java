package com.devcookhome.services;

import java.util.List;

import com.devcookhome.model.Recipe;

public interface RecipeService {
    List<Recipe> findAll();

    Recipe save(Recipe recipe);

    Recipe findById(Long id);

    void delete(Recipe recipe);
}