package com.nganle.dto;

import java.util.ArrayList;
import java.util.List;

import com.nganle.entity.Material;
import com.nganle.support.util.Utils;

public class MaterialSerchDTO {
	private int id;
	private String title;
	private String checked;
	private String featureImage;

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
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

	public String getFeatureImage() {
		return featureImage;
	}

	public void setFeatureImage(String featureImage) {
		this.featureImage = featureImage;
	}

	public static List<MaterialSerchDTO> toListDTO(List<Material> materials) {
		List<MaterialSerchDTO> result = new ArrayList<MaterialSerchDTO>();
		for (Material material : materials) {
			MaterialSerchDTO dto = new MaterialSerchDTO();
			dto.setId(material.getId());
			dto.setTitle(material.getMaterialName());
			dto.setFeatureImage(Utils.convertToFileByte(material.getFeatureImage()));
			result.add(dto);
		}
		return result;
	}
}
