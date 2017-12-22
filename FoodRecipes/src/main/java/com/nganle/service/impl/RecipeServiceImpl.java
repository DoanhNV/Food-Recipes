package com.nganle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nganle.dao.RecipeDAO;
import com.nganle.entity.Recipe;
import com.nganle.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {

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

	public boolean addSavedId(int id,List<Integer> savedUserIds) {
		return recipeDAO.addSavedId(id, savedUserIds);
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

	public List<Recipe> getSlide() {
		return recipeDAO.getSlide();
	}

	public List<Recipe> getTopViews(int number) {
		return recipeDAO.getTopViews(number);
	}

	public List<Recipe> searchByTitle(String title) {
		return recipeDAO.searchByTitle(title);
	}

	public List<Recipe> searchByCate(List<String> listSqlCate) {
		return recipeDAO.searchByCate(listSqlCate);
	}

	public List<Recipe> searchByMaterial(List<Integer> listSqlMaterial,int limit) {
		return recipeDAO.searchByMaterial(listSqlMaterial,limit);
	}

	public List<Recipe> getTopNews(int limit) {
		return recipeDAO.getTopNews(limit);
	}

	public List<Recipe> searchByListId(String listSqlId) {
		return recipeDAO.searchByListId(listSqlId);
	}

	public boolean increaseView(int id) {
		return recipeDAO.increaseView(id);
	}

	public boolean checkExistByCateId(int id) {
		return recipeDAO.checkExistByCateId(id);
	}

}
