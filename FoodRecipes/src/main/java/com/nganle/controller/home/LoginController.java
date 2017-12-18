package com.nganle.controller.home;

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
import com.nganle.support.EntitySupport;
import com.nganle.support.constant.Constant;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;

@Controller
@RequestMapping("/user")
public class LoginController {

	
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
		EntitySupport.initRegisterUser(user);
		boolean isCreated = userService.create(user);
		if (!isCreated) {
			Utils.setErrorMessage(model, "userexist", EXIST_USERNAME);
			model.addAttribute(Constant.ATTRIBUTE_NAME.USER, user);
			return ResultView.HOME.REGISTER;
		}
		return Utils.redirect("/user/login");
	}

	@RequestMapping("/doLogin")
	public String doLogin(@ModelAttribute("loginUser") User user, HttpServletRequest request, ModelMap model) {
		User resultUser = userService.login(user.getUserName(), user.getPassword());
		if (resultUser != null) {
			HttpSession sessions = request.getSession();
			EntitySupport.transferToByteImage(resultUser);
			sessions.setAttribute(Constant.SESSION_NAME.USER_SESSION,resultUser);
			return Utils.redirect("/home/index");
		}
		model.addAttribute("incorrectInfo",INCORRECT_LOGIN);
		return "user.login";
	}
	
	
	@RequestMapping("/logout")
	public String doLogout( HttpServletRequest request) {
		Utils.destroySession( request.getSession(), Constant.SESSION_NAME.USER_SESSION);
		return Utils.redirect("/home/index");
	}

}
