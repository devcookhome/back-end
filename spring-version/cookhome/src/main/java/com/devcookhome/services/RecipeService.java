package com.devcookhome.services;

import com.devcookhome.model.Recipe;

public interface RecipeService {
    Iterable<Recipe> findAll();

    Recipe save(Recipe recipe);

    Recipe findById(Long id);

    void delete(Recipe recipe);
}