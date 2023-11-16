package com.lcsoft.ChefsHubApp.model.dto;

import com.lcsoft.ChefsHubApp.model.entity.RecipeIngredient;
import com.lcsoft.ChefsHubApp.model.entity.UserEntity;
import com.lcsoft.ChefsHubApp.model.enums.CategoryName;
import com.lcsoft.ChefsHubApp.model.enums.RecipeAccessType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.Set;

public class CreateRecipeDto {
    @NotEmpty
    private String name;
    private CategoryName category;
    private Set<RecipeIngredient> ingredients;
    @NotEmpty
    private String description;

    private UserEntity createdBy;
    private LocalDate createdDate;
    private RecipeAccessType recipeAccess;

    public CreateRecipeDto() {
    }

    public CreateRecipeDto(String name, CategoryName category, Set<RecipeIngredient> ingredients, String description, UserEntity createdBy, LocalDate createdDate, RecipeAccessType recipeAccess) {
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.description = description;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.recipeAccess = recipeAccess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }

    public Set<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public RecipeAccessType getRecipeAccess() {
        return recipeAccess;
    }

    public void setRecipeAccess(RecipeAccessType recipeAccess) {
        this.recipeAccess = recipeAccess;
    }
}
