package com.nganle.service;

import java.util.List;

import com.nganle.entity.User;

public interface UserService {
	public boolean create(User user);

	public boolean update(User user);

	public User getById(int userId);

	public List<User> listAll();

	public boolean delete(int userId);

	public User login(String userName, String password);
	
	public boolean changeStatus(int userId, int status);
	
	public List<User> getTopOrder(int limit,String field,String order);
	
	public List<User> findInList(List<Integer> ids);
	
	public boolean saveRecipe(List<String> recipeSavedIds,int id);
}
