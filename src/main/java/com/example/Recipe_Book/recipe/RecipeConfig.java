package com.example.Recipe_Book.recipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RecipeConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            RecipeRepository repository){
        return args -> {
            Recipe noods = new Recipe(
                    "Peanut noodles",
                    "mix all ingredients"
            );
            Recipe bread = new Recipe(
                    "bread",
                    "mix all ingredients"
            );
            repository.saveAll(
                    List.of(noods,bread)
            );
        };
    }
}
