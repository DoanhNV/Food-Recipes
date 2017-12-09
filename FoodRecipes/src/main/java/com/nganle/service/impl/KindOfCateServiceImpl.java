package com.nganle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nganle.dao.KindOfCateDAO;
import com.nganle.entity.KindOfCate;
import com.nganle.service.KindOfCateService;

@Service
public class KindOfCateServiceImpl implements KindOfCateService {

	@Autowired
	private KindOfCateDAO kinDAO;

	public boolean create(KindOfCate kindOfCate) {
		return kinDAO.create(kindOfCate);
	}

	public boolean update(KindOfCate kindOfCate) {
		return kinDAO.update(kindOfCate);
	}

	public boolean delete(int kindId) {
		return kinDAO.delete(kindId);
	}

	public KindOfCate findById(int kindId) {
		return kinDAO.findById(kindId);
	}

	public List<KindOfCate> listAll() {
		return kinDAO.listAll();
	}

}
