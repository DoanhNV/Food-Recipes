package com.nganle.dao;

import java.util.List;

import com.nganle.entity.Recipe;

public interface RecipeDAO {
	public boolean create(Recipe recipe);
	
	public boolean update(Recipe recipe);
	
	public boolean delete(int id);
	
	public Recipe getById(int id);
	
	public List<Recipe> listAll();
	
	public boolean changeStatus(int id,int status);
	
	public boolean addSavedId(int id, int userId);
	
	public boolean addLike(int id,int userId);
	
	public boolean addComment(int id,int commentId);
	
	public boolean changeSlide(int id,int slideValue);
	
	public List<Recipe> getSlide();
}
