package com.nganle.dao;

import java.util.List;

import com.nganle.entity.TipCategory;

public interface TipCateDAO {

	public boolean create(TipCategory cate);

	public boolean update(TipCategory cate);

	public boolean delete(int id);

	public TipCategory getById(int id);

	public List<TipCategory> listAll();

}
