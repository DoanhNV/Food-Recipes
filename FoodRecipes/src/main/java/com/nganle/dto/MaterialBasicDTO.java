package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.entity.Material;

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
	
	public static List<MaterialBasicDTO> toListDTO(List<Material> all,List<Integer> materialIds) {
		List<MaterialBasicDTO> result = new ArrayList<MaterialBasicDTO>();
		for (Integer id : materialIds) {
			MaterialBasicDTO dto = new MaterialBasicDTO();
			for (Material material : all) {
				if(material.getId() == id) {
					dto.setId(material.getId());
					dto.setTitle(material.getMaterialName());
					result.add(dto);
				}
			}
		}
		return result;
	}

}
