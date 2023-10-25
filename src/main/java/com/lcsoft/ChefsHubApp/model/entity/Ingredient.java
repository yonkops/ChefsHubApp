package com.lcsoft.ChefsHubApp.model.entity;

import com.lcsoft.ChefsHubApp.model.enums.IngredientType;
import jakarta.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private IngredientType ingredientType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }
}
