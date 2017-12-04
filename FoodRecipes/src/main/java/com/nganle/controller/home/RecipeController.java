package com.nganle.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	@RequestMapping("/create-recipe")
	public String createRecipe() {
		return "home.create-recipe";
	}
	
	@RequestMapping("/detail")
	public String viewDetail() {
		return "home.recipe";
	}
}
