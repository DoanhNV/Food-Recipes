package com.nganle.dao;

import java.util.List;

import com.nganle.entity.RecipeCategory;

public interface RecipeCategoryDAO {

	public boolean create(RecipeCategory category);

	public boolean update(RecipeCategory category);

	public boolean delete(int id);

	public RecipeCategory getById(int id);

	public List<RecipeCategory> listAll();
	
	public boolean increateNumberOfRecipe(List<String> listId);
}
