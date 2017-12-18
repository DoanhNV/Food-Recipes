package com.nganle.service;

import java.util.List;

import com.nganle.entity.Recipe;

public interface RecipeService {
	public boolean create(Recipe recipe);

	public boolean update(Recipe recipe);

	public boolean delete(int id);

	public Recipe getById(int id);

	public List<Recipe> listAll();

	public boolean changeStatus(int id, int status);

	public boolean addSavedId(int id,List<Integer> savedUserIds);

	public boolean addLike(int id, int userId);

	public boolean addComment(int id, int commentId);

	public boolean changeSlide(int id, int slideValue);

	public List<Recipe> getSlide();

	public List<Recipe> getTopViews(int number);

	public List<Recipe> searchByTitle(String title);

	public List<Recipe> searchByCate(List<String> listSqlCate);

	public List<Recipe> searchByMaterial(List<Integer> listSqlMaterial,int limit);
	
	public List<Recipe> getTopNews(int limit);
	
	public List<Recipe> searchByListId(String listSqlId);
	
	public boolean increaseView(int id);
}
