package com.nganle.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nganle.entity.Recipe;
import com.nganle.entity.User;
import com.nganle.service.RecipeService;
import com.nganle.service.UserService;

@Controller
@RequestMapping("/user")
public class UserVController {

	@Autowired
	private UserService userService;
	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestBody String saveData)  {
		String[] data = saveData.split("-");
		if(data[0].isEmpty()) {
			return "login";
		}
		String recipeIdStr = data[1].replace("=", "");
		int userId = Integer.parseInt(data[0]);
		int recipeId = Integer.parseInt(recipeIdStr);
		
		User user = userService.getById(Integer.parseInt(data[0]));
		List<String> recipeSavedIds = user.getRecipeSavedIds(); 
		Recipe recipe = recipeService.getById(Integer.parseInt(recipeIdStr));
		List<Integer> savedUserIds = recipe.getSavedUserIds();
		if(recipeSavedIds.contains(String.valueOf(recipeId)) || savedUserIds.contains(userId)) {
			return "exist";
		}
		recipeSavedIds.add(recipeIdStr);
		savedUserIds.add(userId);
		userService.saveRecipe(recipeSavedIds, userId);
		recipeService.addSavedId(recipeId,savedUserIds);
		return "success";
	}
}
