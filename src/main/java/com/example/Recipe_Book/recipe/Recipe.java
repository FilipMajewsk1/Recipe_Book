package com.example.Recipe_Book.recipe;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table
public class Recipe {
    //private enum difficulty{beginner,amateur,chef};
    @Id
    @SequenceGenerator(
            name = "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_sequence"
    )
    private long id;
    private String name;
    private String steps;
    private String ingredients;

    public Recipe(long id, String name, String steps, String ingredients) {
        this.id = id;
        this.name = name;
        this.steps = steps;
        this.ingredients = ingredientFormat(ingredients);
    }

    public Recipe(long id, String name, String steps) {
        this.id = id;
        this.name = name;
        this.steps = steps;
    }

    public Recipe() {

    }

    public Recipe(String name, String steps) {
        this.name = name;
        this.steps = steps;
    }
    public Recipe(String name, String steps, String ingredients) {
        this.name = name;
        this.steps = steps;
        this.ingredients = ingredientFormat(ingredients);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getIngredients() {
        return ingredientFormat(ingredients);
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredientFormat(ingredients);
    }
    private static String ingredientFormat(String str){
        if (str==null){
            return "";
        }
        String[] listOfStrings=str.split(",");
        str="";
        for (int i = 0; i<listOfStrings.length;i++){
            if(listOfStrings[i].startsWith(" ")){
                listOfStrings[i]= listOfStrings[i].substring(1);
            }
            if(listOfStrings[i].startsWith("-")){
                listOfStrings[i]= listOfStrings[i].substring(1);
            }
            if(listOfStrings[i].endsWith("\n")){
                listOfStrings[i] = listOfStrings[i].substring(0,listOfStrings[i].length()-1);
            }
            str+=("-"+listOfStrings[i]+"\n");
        }
        return str;
    }
}
