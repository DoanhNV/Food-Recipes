package com.nganle.service;

import java.util.List;

import com.nganle.entity.TipCategory;

public interface TipCateService {
	
	public boolean create(TipCategory cate);

	public boolean update(TipCategory cate);

	public boolean delete(int id);

	public TipCategory getById(int id);

	public List<TipCategory> listAll();
}
