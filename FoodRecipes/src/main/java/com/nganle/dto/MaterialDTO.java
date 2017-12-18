package com.nganle.dto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Base64Utils;

import com.nganle.dao.UserDAO;
import com.nganle.dao.impl.UserDAOImpl;
import com.nganle.entity.Material;
import com.nganle.entity.User;
import com.nganle.support.constant.Constant;
import com.nganle.support.util.DateFormator;

public class MaterialDTO {

	private static final UserDAO userDAO = new UserDAOImpl();

	private int id;
	private String materialName;
	private String featureImage;
	private String createTime;
	private String status;
	private User creater;
	private String checked;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getFeatureImage() {
		return featureImage;
	}

	public void setFeatureImage(String featureImage) {
		this.featureImage = featureImage;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public static List<MaterialDTO> toListDTO(List<Material> materials) {
		List<MaterialDTO> result = new ArrayList<MaterialDTO>();
		if(materials == null) {
			return result;
		}
		for (Material material : materials) {
			MaterialDTO dto = new MaterialDTO();
			dto.setId(material.getId());
			dto.setMaterialName(material.getMaterialName());
			String fileByte = "data:image/png;base64,";
			try {
				byte[] fileBytes = Files.readAllBytes(new File(material.getFeatureImage()).toPath());
				byte[] code = Base64Utils.encode(fileBytes);
				fileByte += new String(code, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			dto.setFeatureImage(fileByte);
			dto.setCreateTime(DateFormator.format_yyyy_MM_dd_hh_mm(material.getCreateTime()));
			User user = userDAO.getById(material.getCreaterId());
			if (user != null) {
				dto.setCreater(user);
			}
			String status = material.getStatus() == 1 ? Constant.STATUS.ACTIVE : Constant.STATUS.DEACTIVE;
			dto.setStatus(status);
			result.add(dto);
		}
		return result;
	}
	
	public static List<MaterialDTO> toListCheckedDTO(List<Material> materials,List<Integer> checkedList) {
		List<MaterialDTO> result = new ArrayList<MaterialDTO>();
		for (Material material : materials) {
			MaterialDTO dto = new MaterialDTO();
			dto.setId(material.getId());
			dto.setMaterialName(material.getMaterialName());
			String fileByte = "data:image/png;base64,";
			try {
				byte[] fileBytes = Files.readAllBytes(new File(material.getFeatureImage()).toPath());
				byte[] code = Base64Utils.encode(fileBytes);
				fileByte += new String(code, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
			dto.setFeatureImage(fileByte);
			dto.setCreateTime(DateFormator.format_yyyy_MM_dd_hh_mm(material.getCreateTime()));
			User user = userDAO.getById(material.getCreaterId());
			if (user != null) {
				dto.setCreater(user);
			}
			String status = material.getStatus() == 1 ? Constant.STATUS.ACTIVE : Constant.STATUS.DEACTIVE;
			dto.setStatus(status);
			if(checkedList.contains(material.getId())) {
				dto.setChecked(Constant.HTML_ATTRIBUTE.CHECKED_VALUE);
			}
			result.add(dto);
		}
		return result;
	}

	public static List<List<MaterialDTO>> toPageList(List<MaterialDTO> list) {
		List<List<MaterialDTO>> result = new ArrayList<List<MaterialDTO>>();
		List<MaterialDTO> element = new ArrayList<MaterialDTO>();
		for (int i = 0; i < list.size(); i++) {
			element.add(list.get(i));
			if ((i + 1) % Constant.NUMBER_PERPAGE == 0) {
				result.add(element);
				element = new ArrayList<MaterialDTO>();
			}
		}

		if (element.size() != 0) {
			result.add(element);
		}
		return result;
	}
	

}
