package com.nganle.dto;

public class RecipeCateBasic {
	private int id;
	private String title;

	public RecipeCateBasic() {

	}

	public RecipeCateBasic(int id, String title) {
		super();
		this.id = id;
		this.title = title;
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

}
