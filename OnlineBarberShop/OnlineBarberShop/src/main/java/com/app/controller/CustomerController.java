package com.app.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.ICustomerDao;
import com.app.pojos.Appointments;
import com.app.pojos.Services;
import com.app.pojos.Shops;
import com.app.pojos.Slots;
import com.app.pojos.Users;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerDao dao;

	public CustomerController() {

		System.out.println("in cnstr of " + getClass().getName());
	}

	@GetMapping("/selectlocation")
	public String searchShopsLocation(Model map) {
		System.out.println("in search location....");
		map.addAttribute("locations_list",dao.getShopsLocations());
		return "/customers/selectlocation";
	}
	

	@PostMapping("/selectshop")
	public String searchShopsByLocation(Model map,@RequestParam String location,RedirectAttributes flashmap,HttpSession hs) 
	{
		System.out.println("in in search shops....");
		//flashmap.addAttribute("shop_location",location);
		hs.setAttribute("shop_location",location);
		map.addAttribute("shops_list",dao.getShopsByLocations(location));
		return "/customers/selectshop";
	}
	
	@PostMapping("/selectservices")
	public String searchServicesById(Model map,@RequestParam int shopId,RedirectAttributes flashmap,HttpSession hs) 
	{
		System.out.println("in in select services....");
		Shops s=dao.getShopByShopId(shopId);
		hs.setAttribute("shop",s);
		System.out.println(s);
		hs.setAttribute("services",dao.getServicesById(shopId));
		return "/customers/selectservices";
	}
	
	@PostMapping("/selectslots")
	public String searchSlotsById(Model map,HttpSession hs,@RequestParam("services") int [] services) 
	{
		
		
		List<Services> serv=new ArrayList<Services>();
		for(int i=0;i<services.length;i++)
		{
			
			serv.add(dao.getServicesByServiceId(services[i]));
		}
		
		hs.setAttribute("serv", serv);
		System.out.println("Sevrices selected list akshay :  "+serv.size());
		System.out.println(serv);
		System.out.println("in  select slots....");
		Shops s=(Shops) hs.getAttribute("shop");
		
		List<Slots> slotlist=new ArrayList<Slots>();
		slotlist=dao.getSlotsById(s.getShopId());
		
		//--------------------------------------------------------------
		Iterator<Slots> itr =slotlist.iterator();
		Slots[] slots=new Slots[slotlist.size()];
		int i=0;
		while(itr.hasNext())
		{
			
			Slots s1=itr.next();
			slots[i]=s1;
			i++;
			
		}
		System.out.println("After Iteretor array sorting print array of slots..........");
		for(int j=0;j<slots.length;j++)
		{
			System.out.println(slots[j]);
		}
		
		
		//--------------------------------------------------------------
		
		List<Slots> slotfinal=new ArrayList<Slots>();
	
		int cnt;
		for(int j=0;j<slots.length;j++)
		{
			cnt=1;
		
			
			{
			while((j+cnt)<slots.length && slots[j].getChaireAvilable()>0 &&slots[j+cnt].getChaireAvilable()!=0)
			{
				if((slots[j].getSlotSequence()+cnt)==slots[j+cnt].getSlotSequence())
				{
					
				
				if(cnt<services.length)
				{
					cnt++;
				}
				if(cnt==services.length)
				{
					
					slotfinal.add(slots[j]);
					break;
				}
				}
				System.out.println("1111111111");
			}
			}
		}
		System.out.println("Slot final list after immedidate slot");
		System.out.println(slotfinal);
		
		//----------------------------------------------------*/
		
	
		if(services.length!=1)
		{
		hs.setAttribute("slotslist",slotfinal);
		}else
		{
			hs.setAttribute("slotslist",dao.getSlotsByIdChaire(s.getShopId()));
		}
		
		return "/customers/selectslots";
			
	
}
	@PostMapping("/bookappoint")
	public String bookAppoint(Model map,HttpSession hs,@RequestParam int slotId)
	{
		List<Services> serv =(List<Services>)hs.getAttribute("serv");
		System.out.println("servies count :" +serv.size());
		List<Slots> slots=new ArrayList<Slots>();
		
		//insert slots into slots list
		Shops shop= (Shops) hs.getAttribute("shop");
		int shopId=shop.getShopId();
		Slots s=dao.getSlotBySlotsId(slotId);
		slots.add(s);
		System.out.println("selected slots are......");
		System.out.println(s);
		int k=s.getSlotSequence();
		
		for(int i=1;i<serv.size();i++)
		{
			slots.add(dao.getSlotBySlotSeqence(k+i,shopId));
			
		}
		hs.setAttribute("selectedslots",slots);
		
		
		return "/customers/bookappoint";
	}
	
	@PostMapping("/bookappointconfirm")
	public String bookAppointConfirm(Model map,HttpSession hs,RedirectAttributes flashmap)
	{
		Appointments a=new Appointments();
		
		//add services to appointmets object
		List<Services> serv= (List<Services>) hs.getAttribute("serv");
		Iterator<Services> itr= serv.iterator();
		Services s=new Services();
		while(itr.hasNext())
		{
			s=itr.next();
			s.getAppoints().add(a);
			a.getServices().add(s);
		}
		
		//add Slots to appointmets object and change chair status to chaireavailable-1
		
				List<Slots> slots= (List<Slots>) hs.getAttribute("selectedslots");
				Iterator<Slots> itr1= slots.iterator();
				Slots slot=new Slots();
				while(itr1.hasNext())
				{
					
					slot=itr1.next();
					slot.getAppoints().add(a);
					a.getSlots().add(slot);
					
					//change chair avilable 
					//dao.changeChaireAvailableCount(slot,slot.getSlotId());
					
				}
				
				//add shop details to appointments
				
				Shops shop=new Shops();
				shop=(Shops) hs.getAttribute("shop");
				a.setShop(shop);
				a.getShop().getAppointments().add(a);
				
				//Add User Details to Appointments Object
				Users user=new Users();
				user=(Users) hs.getAttribute("user_dtls");
				a.setUser(user);
				user.getAppoints().add(a);
				
		//Call Customerdao bookConfirm Appointmets funcion.
		
				//flashmap.addAttribute("bookstatus",dao.bookAppointConfirm(a));
				hs.setAttribute("bookstatus", dao.bookAppointConfirm(a));
				
				//change chair Available status 
				
				return "/customers/bookappointconfirm";
	}
	@PostMapping("/changechaire")
	public String changeChaire(Model map,HttpSession hs,RedirectAttributes flashmap)
	{
	
	List<Slots> slots=(List<Slots>) hs.getAttribute("selectedslots");
	//hs.removeAttribute("selectedslots");
	//hs.removeAttribute("slotslist");

	Iterator<Slots> itr1= slots.iterator();
	Slots slot=new Slots();
	while(itr1.hasNext())
	{
		
		slot=itr1.next();
		//change chair avilable 
		
		dao.changeChaireAvailableCount(slot,slot.getSlotId());
		
		
	}	
	return "/customers/hi";
	}

}
