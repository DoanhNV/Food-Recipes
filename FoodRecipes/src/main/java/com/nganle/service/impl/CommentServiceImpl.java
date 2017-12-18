package com.nganle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nganle.dao.CommentDAO;
import com.nganle.entity.Comment;
import com.nganle.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	public boolean create(Comment comment) {
		return commentDAO.create(comment);
	}

	public boolean update(Comment comment) {
		return commentDAO.update(comment);
	}

	public boolean delete(int id) {
		return commentDAO.delete(id);
	}

	public List<Comment> getByRecipeId(int recipeid) {
		return commentDAO.getByRecipeId(recipeid);
	}

	public List<Comment> listAll() {
		return commentDAO.listAll();
	}

}
