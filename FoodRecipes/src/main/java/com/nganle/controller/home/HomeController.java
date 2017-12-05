package com.nganle.controller.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nganle.dao.AbstractDAO;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String loadIndex(HttpServletRequest request) {
		return "redirect:/home/index";
	}
	
	
	@RequestMapping("/home/index")
	public String loadHome(HttpServletRequest request) {
		return "home.index";
	}

}
