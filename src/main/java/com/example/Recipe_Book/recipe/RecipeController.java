package com.example.Recipe_Book.recipe;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.Optional;

@Tag(name = "Recipe_book", description = "Recipe_book management APIs")
@RestController
@RequestMapping(path="api/v1/recipe")



public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(
            summary = "Retrieve all Recipes",
            description = "Get a list of all Recipe objects. The response is a list of Recipe objects with id, name, ingredients and steps.",
            tags = { "get" })
    @GetMapping
    public Iterable<Recipe> getRecipes(){
        return(recipeService.getRecipes());
    }

    @Operation(
            summary = "Retrieve a Recipe by id",
            description = "Get a Recipe object by specifying its id The response is Recipe object with id, name, ingredients and steps.",
            tags = { "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Recipe.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(path = "{recipeId}")
    public Optional<Recipe> getRecipe(@PathVariable("recipeId") Long recipeId){return (recipeService.getRecipe(recipeId));}

    @Operation(
            summary = "Add a new Recipe",
            description = "Add a new Recipe object by specifying its name, ingredients and steps.",
            tags = { "post" })
    @PostMapping(value = "")
    public void registerNewRecipe(@RequestBody Recipe recipe){
        recipeService.addNewRecipe(new Recipe(recipe.getName(), recipe.getIngredients(), recipe.getSteps()));
    }

    @Operation(
            summary = "Delete a Recipe",
            description = "Delete a Recipe object by specifying its id",
            tags = { "delete" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Recipe.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
             })
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
