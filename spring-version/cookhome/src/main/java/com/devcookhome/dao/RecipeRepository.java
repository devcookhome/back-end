package com.devcookhome.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.devcookhome.model.Recipe;
import org.springframework.data.domain.Sort;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAll(Sort sort);

}
