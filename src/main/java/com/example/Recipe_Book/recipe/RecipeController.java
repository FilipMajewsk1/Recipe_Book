package com.example.Recipe_Book.recipe;

import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1")



public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getRecipes(){
        return(recipeService.getRecipes());
    }

    @PostMapping
    public void registerNewRecipe(@RequestBody Recipe recipe){
        recipeService.addNewRecipe(recipe);
    }

    @DeleteMapping(path = "{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long recipeId){
        recipeService.deleteRecipe(recipeId);
    }

    @PutMapping(path = "{recipeId}")
    public void updateRecipe(
            @PathVariable("recipeId") Long recipeId,
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String steps,
            @RequestParam(required=false) String ingredients){
            recipeService.updateRecipe(recipeId,name,steps,ingredients);}
}
