package com.nganle.controller.home;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nganle.dao.UserDAO;
import com.nganle.entity.User;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/login")
	public String login() {
		
		return "user.login";
	}
	
	@RequestMapping("/register")
	public String register() {
		User user = new User();
		user.setUserName("doanh");
		user.setEmail("123123");
		user.setPassword("1232");
		user.setMd5Password("sdfsdfsfds");
		user.setFullName("ngo van doanh");
		user.setProfileImage("12313213123");
		user.setBirthday(new Date());
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		user.setRecipeSavedIds(new ArrayList<String>());
		user.setTipSavedIds(new ArrayList<String>());
		userDAO.create(user);
		return "user.register";
	}
}
