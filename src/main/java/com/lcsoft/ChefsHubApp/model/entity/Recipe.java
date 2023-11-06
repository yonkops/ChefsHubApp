package com.lcsoft.ChefsHubApp.model.entity;

import com.lcsoft.ChefsHubApp.model.enums.CategoryName;
import com.lcsoft.ChefsHubApp.model.enums.RecipeAccessType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private CategoryName category;
    @OneToMany(mappedBy = "recipe")
    private Set<RecipeIngredient> ingredients;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    private UserEntity createdBy;
    private LocalDate createdDate;
    @Enumerated(EnumType.STRING)
    private RecipeAccessType recipeAccess;


    public Recipe() {
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
