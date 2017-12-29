package com.nganle.dao;

import java.util.List;

import com.nganle.entity.Material;

public interface MaterialDAO {
	public boolean create(Material material);
	
	public boolean update(Material material);
	
	public Material getById(int id);
	
	public List<Material> listAll();
	
	public boolean deleteById(int id);
	
	public List<Material> getTopLimit(int limit,String field, String order);
	
	public List<Material> searchByTitle(String title);
}
