package com.nganle.dto;

public class RecipeCateBasic {
	private int id;
	private String title;
	private String checked;
	private int recipeNumber;

	public RecipeCateBasic() {

	}

	public RecipeCateBasic(int id, String title, int recipeNumber) {
		super();
		this.id = id;
		this.title = title;
		this.recipeNumber = recipeNumber;
	}

	public RecipeCateBasic(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public RecipeCateBasic(int id, String title, String checked) {
		super();
		this.id = id;
		this.title = title;
		this.checked = checked;
	}

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

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public int getRecipeNumber() {
		return recipeNumber;
	}

	public void setRecipeNumber(int recipeNumber) {
		this.recipeNumber = recipeNumber;
	}

}
