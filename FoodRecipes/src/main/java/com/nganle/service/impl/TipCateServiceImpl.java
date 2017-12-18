package com.nganle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nganle.dao.TipCateDAO;
import com.nganle.entity.TipCategory;
import com.nganle.service.TipCateService;

@Service
public class TipCateServiceImpl implements TipCateService {
	
	@Autowired
	private TipCateDAO cateDAO;
	
	public boolean create(TipCategory cate) {
		return cateDAO.create(cate);
	}

	public boolean update(TipCategory cate) {
		return cateDAO.update(cate);
	}

	public boolean delete(int id) {
		return cateDAO.delete(id);
	}

	public TipCategory getById(int id) {
		return cateDAO.getById(id);
	}

	public List<TipCategory> listAll() {
		return cateDAO.listAll();
	}
	
}
