package com.nganle.service;

import java.util.List;

import com.nganle.entity.Tip;

public interface TipService {
	
	public boolean create(Tip tip);

	public boolean update(Tip tip);

	public boolean delete(int id);

	public Tip getById(int id);

	public List<Tip> listAll();
	
	public List<Tip> getTopLimit(int limit, String field, String order);
	
	public List<Tip> searchByListId(String listSQLId);
	
	public List<Tip> searchByCateId(int cateId) ;
	
	public List<Tip> getSuggest(int id, int limit);
}
