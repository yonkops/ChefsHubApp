package com.lcsoft.ChefsHubApp.web;

import com.lcsoft.ChefsHubApp.model.dto.CreateRecipeDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @GetMapping("/add")
    public String addRecipe(CreateRecipeDto createRecipeDto) {
        return "recipe-add";
    }
}
