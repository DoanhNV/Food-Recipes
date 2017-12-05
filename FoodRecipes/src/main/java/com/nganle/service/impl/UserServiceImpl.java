package com.nganle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nganle.dao.UserDAO;
import com.nganle.entity.User;
import com.nganle.service.AbstractService;
import com.nganle.service.UserService;

@Service
public class UserServiceImpl extends AbstractService implements UserService {

	@Autowired
	private UserDAO userDAO;

	public boolean create(User user) {
		if (userDAO.isExistByUserName(user.getUserName())) {
			return userDAO.create(user);
		}
		return false;
	}

	public boolean update(User user) {
		return userDAO.update(user);
	}

	public User getById(int userId) {
		return userDAO.getById(userId);
	}

	public List<User> listAll() {
		return userDAO.listAll();
	}

	public boolean delete(int userId) {
		return userDAO.delete(userId);
	}

	public User login(String userName, String password) {
		User resultUser = userDAO.getByUserNameAndPassword(userName, password);
		return resultUser;
	}

}
