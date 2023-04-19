package com.example.Recipe_Book.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes(){
        return(recipeRepository.findAll());
    }

    public void addNewRecipe(Recipe recipe) {
        Optional<Recipe> recipeByName=recipeRepository.findRecipeByName(recipe.getName());
        if (recipeByName.isPresent()) {
            throw new IllegalStateException("recipe already saved");
        }
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long recipeId) {
        boolean exists = recipeRepository.existsById(recipeId);
        if(!exists){
            throw new IllegalStateException("Recipe ID " + recipeId +" does not exist");
        }
        recipeRepository.deleteById(recipeId);
    }

    @Transactional
    public void updateRecipe(Long recipeId,
                             String name,
                             String steps,
                             String ingredients) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalStateException("Recipe ID " + recipeId + " does not exist"));

        if(name!=null && name.length()>0 && !Objects.equals(recipe.getName(),name)){
            Optional<Recipe> recipeByName=recipeRepository.findRecipeByName(name);
            if(recipeByName.isPresent()){
                throw new IllegalStateException("Recipe already exists");
            }
            recipe.setName(name);
        }

        if(steps!=null && steps.length()>0 && !Objects.equals(recipe.getSteps(),steps)){
            recipe.setSteps(steps);
        }

        if(ingredients!=null && ingredients.length()>0 && !Objects.equals(recipe.getIngredients(),ingredients)){
            recipe.setIngredients(ingredients);
        }
    }
}
