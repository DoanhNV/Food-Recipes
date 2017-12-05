package com.nganle.service;

import java.util.List;

import com.nganle.entity.User;

public interface UserService {
	public boolean create(User user);

	public boolean update(User user);

	public User getById(int userId);

	public List<User> listAll();

	public boolean delete(int userId);
	
	public User login(String userName,String password);
}
