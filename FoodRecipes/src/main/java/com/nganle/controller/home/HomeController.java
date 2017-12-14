package com.nganle.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String loadIndex() {
		return "redirect:/home/index";
	}

	@RequestMapping("/home/index")
	public String loadHome() {
		return "home.index";
	}

}
