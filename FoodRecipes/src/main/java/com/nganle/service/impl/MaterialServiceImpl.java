package com.nganle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nganle.dao.MaterialDAO;
import com.nganle.entity.Material;
import com.nganle.service.AbstractService;
import com.nganle.service.MaterialService;

@Service
public class MaterialServiceImpl extends AbstractService implements MaterialService {

	@Autowired
	private MaterialDAO materialDAO;

	public boolean create(Material material) {
		return materialDAO.create(material);
	}

	public boolean update(Material material) {
		return materialDAO.update(material);
	}

	public Material getById(int id) {
		return materialDAO.getById(id);
	}

	public List<Material> listAll() {
		return materialDAO.listAll();
	}

	public boolean deleteById(int id) {
		return materialDAO.deleteById(id);
	}

}
