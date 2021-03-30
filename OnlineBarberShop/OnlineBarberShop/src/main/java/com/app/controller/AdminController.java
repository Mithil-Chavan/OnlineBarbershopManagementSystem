package com.app.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.IAdminDao;
import com.app.pojos.Shops;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminDao dao;

	public AdminController() {
		System.out.println("in cnstr of " + getClass().getName());
	}


	@GetMapping("/shopsdetails")
	public String showShopList(Model map) {
		System.out.println("in show shops list");
		map.addAttribute("shops_list",dao.getShops());
		return "/admin/shopsdetails";
	}
	
	@GetMapping("/delete")
	public String removeShop(@RequestParam int sid,RedirectAttributes flashMap,Model map)
	{
	
		System.out.println("in del shop " + sid);
		flashMap.addFlashAttribute("mesg", dao.removeShop(sid));
		map.addAttribute("shops_list",dao.getShops());
		return "/admin/shopsdetails";
	}
	@GetMapping("/register")
	public String registerShop(Shops s)
	{
	System.out.println("in shop show reg form");
		
		return "/admin/register";
	}
	

	
	@PostMapping("/register")
	public String processRegForm( Shops s, RedirectAttributes flashMap) {
		
		System.out.println("in process reg form " + s);// transient
		flashMap.addFlashAttribute("mesg", dao.addNewShop(s));
		return "redirect:/admin/shopsdetails";
	}
	
	@GetMapping("/update")
	public String showUpdateShopForm(@RequestParam int sid,HttpSession hs,Model map)
	{
		Shops shop=dao.getShopByShopId(sid);
		hs.setAttribute("updateshop", shop);
		map.addAttribute("shop_detalis",shop);
		System.out.println("in shop Update form");
		hs.setAttribute("sid_update",sid);
		return "/admin/update";
	}
	@PostMapping("/update")
	public String ProcessUpdateShopForm(@RequestParam String shopName,@RequestParam String ownerName,@RequestParam String location,@RequestParam String contactNumber,HttpSession hs,Model map)
	{
		System.out.println("in shop Update form");
		
		Shops shop=(Shops) hs.getAttribute("updateshop");
		shop.setShopName(shopName);
		shop.setOwnerName(ownerName);
		shop.setLocation(location);
		shop.setContactNumber(contactNumber);
		
		map.addAttribute("updatestatus",dao.updateShop(shop));	
		return "redirect:/admin/shopsdetails";
	}
	
	
}

