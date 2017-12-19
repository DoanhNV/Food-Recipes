package com.nganle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nganle.dao.RecipeCategoryDAO;
import com.nganle.entity.RecipeCategory;
import com.nganle.service.RecipeCategoryService;

@Service
public class RecipeCategoryServiceImpl implements RecipeCategoryService {

	@Autowired
	private RecipeCategoryDAO cateDAO;

	public boolean create(RecipeCategory category) {
		return cateDAO.create(category);
	}

	public boolean update(RecipeCategory category) {
		return cateDAO.update(category);
	}

	public boolean delete(int id) {
		return cateDAO.delete(id);
	}

	public RecipeCategory getById(int id) {
		return cateDAO.getById(id);
	}

	public List<RecipeCategory> listAll() {
		return cateDAO.listAll();
	}

	public boolean increateNumberOfRecipe(List<String> listId) {
		return cateDAO.increateNumberOfRecipe(listId);
	}

}
