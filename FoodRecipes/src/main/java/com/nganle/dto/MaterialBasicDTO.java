package com.nganle.dto;

public class MaterialBasicDTO {
	private int id;
	private String title;

	public MaterialBasicDTO() {

	}

	public MaterialBasicDTO(int id, String title) {
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
