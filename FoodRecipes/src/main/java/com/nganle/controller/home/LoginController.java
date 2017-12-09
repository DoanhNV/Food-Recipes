package com.nganle.controller.home;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nganle.entity.User;
import com.nganle.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController {

	private static final String DEFAULT_IMAGE = "/resources/asset/img/cooker.png";
	private static final String EXIST_USERNAME = "tên đăng nhập đã tồn tại!";
	private static final String INCORRECT_LOGIN = "tên đăng nhập hoặc mật khẩu không chính xác!";

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "user.login";
	}

	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		return "user.register";
	}

	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public String doRegister(@ModelAttribute("registerUser") User user, HttpServletRequest request, ModelMap model) {
		user.setBirthday(new Date());
		user.setCreateTime(new Date(System.currentTimeMillis()));
		user.setUpdateTime(new Date(System.currentTimeMillis()));
		user.setRecipeSavedIds(new ArrayList<String>());
		user.setTipSavedIds(new ArrayList<String>());
		user.setProfileImage(DEFAULT_IMAGE);
		boolean isCreated = userService.create(user);
		if (!isCreated) {
			model.addAttribute("userexist", EXIST_USERNAME);
			return "user.register";
		}
		return "redirect:/user/login";
	}

	@RequestMapping("/doLogin")
	public String doLogin(@ModelAttribute("loginUser") User user, HttpServletRequest request, ModelMap model) {
		User resultUser = userService.login(user.getUserName(), user.getPassword());
		if (resultUser != null) {
			HttpSession sessions = request.getSession();
			sessions.setAttribute("sessionUser", resultUser);
			return "redirect:/home/index";
		}
		model.addAttribute("incorrectInfo",INCORRECT_LOGIN);
		return "user.login";
	}
	
	
	@RequestMapping("/logout")
	public String doLogout( HttpServletRequest request) {
		HttpSession sessions = request.getSession();
		sessions.removeAttribute("sessionUser");
		return "redirect:/home/index";
	}

}
