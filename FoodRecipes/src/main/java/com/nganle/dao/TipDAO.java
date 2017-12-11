package com.nganle.dao;

import java.util.List;

import com.nganle.entity.Tip;

public interface TipDAO {
	
	public boolean  create(Tip tip);
	
	public boolean update(Tip tip);
	
	public boolean delete(int id);
	
	public Tip getById(int id);
	
	public List<Tip> listAll();
}
