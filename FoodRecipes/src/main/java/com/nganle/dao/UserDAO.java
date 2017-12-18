package com.nganle.dao;

import java.util.List;

import com.nganle.entity.User;

public interface UserDAO {
	public boolean create(User user);

	public boolean update(User user);

	public User getById(int userId);

	public List<User> listAll();

	public boolean delete(int userId);

	public User getByUserNameAndPassword(String userName, String password);

	public boolean isExistByUserName(String userName);
	
	public boolean changeStatus(int userId,int status);
	
	public List<User> getTopOrder(int limit,String field,String order);
	
	public List<User> findInList(List<Integer> ids);
	
	public boolean saveRecipe(List<String> recipeSavedIds,int id);
}
