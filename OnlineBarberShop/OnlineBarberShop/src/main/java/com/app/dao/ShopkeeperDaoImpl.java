package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Appointments;
import com.app.pojos.Services;
import com.app.pojos.Shops;
import com.app.pojos.Slots;
@Repository
@Transactional
public  class ShopkeeperDaoImpl implements IShopkeeperDao{

	@Autowired 
	private EntityManager mgr;
	
	@Override
	public String addService(Services s) {
		
		 mgr.persist(s);
		return "Service registered successfully : ID "+s.getServiceId();
	}

	@Override
	public String removeService(int serviceId) {
	
		Services s = mgr.find(Services.class,serviceId);
		if (s != null) {
			mgr.remove(s);
			return "service un-subscribed with ID " + s.getServiceId();
		}
		return "Service deletion failed : Invalid Vendor ID";
	}

	@Override
	public String addSlot(Slots s) {
		
		 mgr.persist(s);
		return "Service registered successfully : ID "+s.getSlotId();
		
	}
	
	@Override
	public String removeSlot(int slotId) {
		
		Slots s = mgr.find(Slots.class,slotId);
		if (s != null) {
			mgr.remove(s);
			return "slot un-subscribed with ID " + s.getSlotId();
		}
		return "Slot deletion failed : Invalid Vendor ID";
	}
	

	

	@Override
	public List<Appointments> appointmetsList(String ownerName) {

		Shops s=getShopByOwnerName(ownerName);
		String jpql = "select a from Appointments a where shop_id=:sid";
		List<Appointments> alist=new ArrayList<Appointments>();
		alist=mgr.createQuery(jpql, Appointments.class).setParameter("sid",s.getShopId()).getResultList();
		return alist;
	}
	
	@Override
	public String updateService(int serviceId, Services s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String UpdateSlot(int slotId, Slots s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shops getShopByOwnerName(String owName) {
		String jpql="select s from Shops s where ownerName=:owName";
		return mgr.createQuery(jpql, Shops.class).setParameter("owName",owName).getSingleResult();
	}

	@Override
	public List<Services> getServiceList(String ownerName) {
		Shops s=getShopByOwnerName(ownerName);
		String jpql = "select s from Services s where shop_id=:sid";
		List<Services> slist=new ArrayList<Services>();
		slist=mgr.createQuery(jpql,Services.class).setParameter("sid",s.getShopId()).getResultList();
		return slist;
	}
	@Override
	public List<Slots> getSlotsList(String ownerName) {
		Shops s=getShopByOwnerName(ownerName);
		String jpql = "select s from Slots s where shop_id=:sid";
		List<Slots> slist=new ArrayList<Slots>();
		slist=mgr.createQuery(jpql,Slots.class).setParameter("sid",s.getShopId()).getResultList();
		return slist;
	}

	@Override
	public Services getServicesByServiceId(int serviceId) {
		
		String jpql="select s from Services s where s.serviceId=:serviceid";
		return mgr.createQuery(jpql,Services.class).setParameter("serviceid",serviceId).getSingleResult();
	}

	@Override
	public Slots getSlotBySlotsId(int slotId) {
		
		
		String jpql="select s from Slots s where s.slotId=:slotid";
		return mgr.createQuery(jpql,Slots.class).setParameter("slotid",slotId).getSingleResult();
	}

	@Override
	public String updateService(Services s) {
		mgr.merge(s);
		return "Service Updated successfully : ID "+s.getServiceId();
	}

	@Override
	public String updateSlot(Slots s) {
		mgr.merge(s);
		return "slot Updated successfully : ID "+s.getSlotId();
	}
}
