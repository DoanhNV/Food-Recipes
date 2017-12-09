package com.nganle.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nganle.entity.User;
import com.nganle.service.UserService;
import com.nganle.support.constant.Message;
import com.nganle.support.constant.ResultView;
import com.nganle.support.util.Utils;
import com.nganle.support.validate.Validator;

import static com.nganle.support.constant.Constant.SESSION_NAME.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@RequestMapping("")
	public String loadRoot() {
		return "redirect:/admin/index";
	}

	@RequestMapping("/index")
	public String loadIndex(HttpServletRequest request) {
		if (!Validator.isExistSession(request.getSession(), ADMIN_SESSION)) {
			return "redirect:/admin/login";
		}
		return ResultView.ADMIN.INDEX;
	}

	@RequestMapping("/logout")
	public String doLogout(HttpServletRequest request) {
		Utils.destroySession(request.getSession(), ADMIN_SESSION);
		return "redirect:/admin/login";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return ResultView.ADMIN.LOGIN;
	}

	@RequestMapping("/doLogin")
	public String doLogin(HttpServletRequest request, @ModelAttribute("adminUser") User user, ModelMap model) {
		User admin = userService.login(user.getUserName(), user.getPassword());
		if (!Validator.isAdmin(admin)) {
			Utils.setErrorMessage(model, "admin_login_fail", Message.ADMIN_LOGIN_FAIL);
			return ResultView.ADMIN.LOGIN;
		}
		Utils.setSession(request.getSession(), ADMIN_SESSION, admin);
		return "redirect:/admin/index";
	}
}
