package com.nganle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nganle.dao.RecipeDAO;
import com.nganle.entity.Recipe;
import com.nganle.service.RecipeService;

@Service
public class RecipeServiceImpl  implements RecipeService{
	
	@Autowired
	private RecipeDAO recipeDAO;
	
	public boolean create(Recipe recipe) {
		return recipeDAO.create(recipe);
	}

	public boolean update(Recipe recipe) {
		return recipeDAO.update(recipe);
	}

	public boolean delete(int id) {
		return recipeDAO.delete(id);
	}

	public Recipe getById(int id) {
		return recipeDAO.getById(id);
	}

	public List<Recipe> listAll() {
		return recipeDAO.listAll();
	}

	public boolean changeStatus(int id, int status) {
		return recipeDAO.changeStatus(id, status);
	}

	public boolean addSavedId(int id, int userId) {
		return recipeDAO.addSavedId(id, userId);
	}

	public boolean addLike(int id, int userId) {
		return recipeDAO.addLike(id, userId);
	}

	public boolean addComment(int id, int commentId) {
		return recipeDAO.addComment(id, commentId);
	}

	public boolean changeSlide(int id, int slideValue) {
		return recipeDAO.changeSlide(id, slideValue);
	}

}
