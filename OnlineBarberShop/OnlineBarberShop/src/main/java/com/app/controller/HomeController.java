package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	@RequestMapping("/")
	public String showWelcomePage() {
		System.out.println("in show welcome page");
		return "/index";//actual view name : /WEB-INF/views/index.jsp
	}
	@RequestMapping("/about")
	public String showAboutUsPage() {
		System.out.println("in show about us page");
		return "/user/about";//actual view name : /WEB-INF/views/.....
	}

	@RequestMapping("/contact")
	public String showContactUsPage() {
		System.out.println("in show contact us page");
		return "/user/contact";//actual view name : /WEB-INF/views/.....
	}

}