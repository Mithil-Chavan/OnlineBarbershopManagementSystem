

package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IUserDao;
import com.app.pojos.Users;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired 
	private IUserDao dao;

	public UserController() {
		System.out.println("in user controller constr");
	}


	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

	
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String em,
			@RequestParam String pass, Model map,
			RedirectAttributes flashMap, HttpSession hs) {
		System.out.println("in process login form");
		
		try {
			Users u = dao.auntheticateUser(em, pass);
		
			hs.setAttribute("user_dtls", u);
			flashMap.addFlashAttribute("mesg", "Login Successful");
			
			if (u.getRole().equals("customer"))
			{
				return "/customers/details";
			}
			else if (u.getRole().equals("admin"))
			{
				return "redirect:/admin/shopsdetails";
			}
			else
			{
				return "redirect:/shopkeeper/appointments";
			}
			
		
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			map.addAttribute("mesg", "Invalid Login");
			
			return "/user/login";
		}

	}

	
	@GetMapping("/logout")
	public String userLogout(HttpSession hs,Model map,HttpServletRequest request,HttpServletResponse resp) {
		System.out.println("in user logout");
	
		map.addAttribute("u_dtls",hs.getAttribute("user_dtls"));
		
		resp.setHeader("refresh", "500;url="+request.getContextPath());
	
		hs.invalidate();
		return "/user/logout";
	}

	
	@GetMapping("/register")
	public String showregisterForm(Users user) {
		System.out.println("in show login form");
		return "/user/register";
	}
	

	@PostMapping("/register")
	public String processRegisterForm(Model map,RedirectAttributes flashMap,Users user) 
	{
		System.out.println("in User process register form");
			
			try {
				String	 regstatus=dao.registerUser(user);
			map.addAttribute("regstatus",regstatus);
			}
			catch(Exception e)
			{		
				e.printStackTrace();
				String regstatus="User Registration Fail";
				map.addAttribute("regstatus",regstatus);
			}
		return "/user/regstatus";
	}
}
