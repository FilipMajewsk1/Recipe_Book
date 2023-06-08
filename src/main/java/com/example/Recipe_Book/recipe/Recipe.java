package com.example.Recipe_Book.recipe;

import jakarta.persistence.*;


@Entity
@Table
public class Recipe {
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
    private Long id;
    private String name;
    private String ingredients;
    private String steps;

    public Recipe(Long id, String name, String steps, String ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Recipe(Long id, String name, String steps) {
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
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
