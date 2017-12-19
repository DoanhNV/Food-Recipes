package com.nganle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nganle.dao.TipDAO;
import com.nganle.entity.Tip;
import com.nganle.service.TipService;

@Service
public class TipServiceImpl implements TipService {

	@Autowired
	private TipDAO tipDAO;
	
	public boolean create(Tip tip) {
		return tipDAO.create(tip);
	}

	public boolean update(Tip tip) {
		return tipDAO.update(tip);
	}

	public boolean delete(int id) {
		return tipDAO.delete(id);
	}

	public Tip getById(int id) {
		return tipDAO.getById(id);
	}

	public List<Tip> listAll() {
		return tipDAO.listAll();
	}

	public List<Tip> getTopLimit(int limit, String field, String order) {
		return tipDAO.getTopLimit(limit, field, order);
	}

	public List<Tip> searchByListId(String listSQLId) {
		return tipDAO.searchByListId(listSQLId);
	}

	public List<Tip> searchByCateId(int cateId) {
		return tipDAO.searchByCateId(cateId);
	}

	public List<Tip> getSuggest(int id, int limit) {
		return tipDAO.getSuggest(id, limit);
	}

	public boolean increateView(int id) {
		return tipDAO.increateView(id);
	}

}
