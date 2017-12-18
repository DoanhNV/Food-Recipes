package com.nganle.dto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.nganle.entity.RecipeCategory;
import com.nganle.support.util.Utils;

public class RecipeCateForHomeDTO {
	private int id;
	private String title;
	private int numberOfRecipes;
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfRecipes() {
		return numberOfRecipes;
	}

	public void setNumberOfRecipes(int numberOfRecipes) {
		this.numberOfRecipes = numberOfRecipes;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	public static List<RecipeCateForHomeDTO> toListDTO(List<RecipeCategory> cates,int limit){
		List<RecipeCateForHomeDTO> result = new ArrayList<RecipeCateForHomeDTO>();
		limit = limit < cates.size() ? limit : cates.size();
		List<String> resources = getResources();
		for (int i = 0; i < limit; i++) {
			RecipeCateForHomeDTO dto = new RecipeCateForHomeDTO();
			RecipeCategory cate = cates.get(i);
			dto.setId(cate.getId());
			dto.setTitle(cate.getCateTitle());
			dto.setNumberOfRecipes(cate.getNumberOfRecipe());
			dto.setImage(resources.get(i));
			result.add(dto);
		}
		return result;
	}
	
	public static List<String> getResources() {
		List<String> files = new ArrayList<String>();
		try {
			File file2;
			file2 = new ClassPathResource("asset/img").getFile();
			File[] listFiles = file2.listFiles();
			for (File file : listFiles) {
				files.add(Utils.convertToFileByte(file.getAbsolutePath()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return files;
	}
	
}
