package com.nganle.service;

import java.util.List;

import com.nganle.entity.Comment;

public interface CommentService {
	public boolean create(Comment comment);

	public boolean update(Comment comment);

	public boolean delete(int id);

	public List<Comment> getByRecipeId(int recipeid);

	public List<Comment> listAll();
}
