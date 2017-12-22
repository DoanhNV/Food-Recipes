package com.nganle.service;

import java.util.List;

import com.nganle.entity.RecipeCategory;

public interface RecipeCategoryService {

	public boolean create(RecipeCategory category);

	public boolean update(RecipeCategory category);

	public boolean delete(int id);

	public RecipeCategory getById(int id);

	public List<RecipeCategory> listAll();
	
	public boolean increateNumberOfRecipe(List<String> listId);
	
	public boolean decreateNumberOfRecipe(List<String> listId);
	
	public List<RecipeCategory> listMenu(int limit);
}
