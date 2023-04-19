package com.example.Recipe_Book;

import com.example.Recipe_Book.recipe.Recipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@SpringBootApplication

public class RecipeBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBookApplication.class, args);
	}


}
