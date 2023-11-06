package com.lcsoft.ChefsHubApp.model.repository;

import com.lcsoft.ChefsHubApp.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
