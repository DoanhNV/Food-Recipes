package com.nganle.dao;

import java.util.List;

import com.nganle.entity.KindOfCate;

public interface KindOfCateDAO {
	public boolean create(KindOfCate kindOfCate);
	
	public boolean update(KindOfCate kindOfCate);
	
	public boolean delete(int kindId);
	
	public KindOfCate findById(int kindId);
	
	public List<KindOfCate> listAll();
}
