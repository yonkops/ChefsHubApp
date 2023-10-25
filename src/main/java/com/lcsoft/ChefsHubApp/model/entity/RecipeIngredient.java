package com.lcsoft.ChefsHubApp.model.entity;

import com.lcsoft.ChefsHubApp.model.enums.UnitType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
@Table
public class RecipeIngredient extends BaseEntity {
    @ManyToOne
    private Recipe recipe;
    @ManyToOne
    private Ingredient ingredient;
    @Positive
    @Column(nullable = false)
    private Double quantity;
    @Enumerated(EnumType.STRING)
    private UnitType unit;

    public RecipeIngredient() {
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }
}
