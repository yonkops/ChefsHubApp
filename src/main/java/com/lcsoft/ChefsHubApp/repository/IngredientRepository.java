package com.lcsoft.ChefsHubApp.repository;

import com.lcsoft.ChefsHubApp.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
