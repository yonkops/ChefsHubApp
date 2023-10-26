package com.lcsoft.ChefsHubApp.repository;

import com.lcsoft.ChefsHubApp.model.entity.RecipeReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<RecipeReview, Long> {
}
