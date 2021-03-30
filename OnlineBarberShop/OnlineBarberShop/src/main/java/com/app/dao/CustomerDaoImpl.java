package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Appointments;
import com.app.pojos.Services;
import com.app.pojos.Shops;
import com.app.pojos.Slots;

@Repository
@Transactional
public class CustomerDaoImpl implements ICustomerDao {

	//private static final String Query = null;
	@PersistenceContext 
	private EntityManager mgr;
	
	@Override
	public List<String> getShopsLocations() {

		String jpql = "select distinct s.location from Shops s ";
		return mgr.createQuery(jpql, String.class).getResultList();
	}

	@Override
	public String bookAppointment() {

		return null;
	}

	@Override
	public List<Appointments> viewAppointments(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String feedbackSubmit(int shopId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shops> getShopsByLocations(String location) {

		String jpql = "select s from Shops s where s.location =:loc";
		return mgr.createQuery(jpql, Shops.class).setParameter("loc", location).getResultList();
	}

	@Override
	public List<Services> getServicesById(int shopId) {

		String jpql = "select s from Services s join fetch s.shop where s.shop.shopId=:shop_Id";
		return mgr.createQuery(jpql, Services.class).setParameter("shop_Id", shopId).getResultList();
	}

	@Override
	public List<Slots> getSlotsById(int shopId) {

		String jpql = "select s from Slots s join fetch s.shop where s.shop.shopId=:shop_Id order by s.slotSequence";
		List<Slots> slotlist = mgr.createQuery(jpql, Slots.class).setParameter("shop_Id", shopId)
				.getResultList();
		System.out.println("in side dao get slots by shopid............");
		System.out.println(slotlist);

		return slotlist;
	}

	@Override
	public Shops getShopByShopId(int shopId) {

		String jpql = "select s from Shops s where s.shopId=:shopid";
		return mgr.createQuery(jpql, Shops.class).setParameter("shopid", shopId).getSingleResult();
	}

	@Override
	public Services getServicesByServiceId(int serviceId) {

		String jpql = "select s from Services s where s.serviceId=:serviceid";
		return mgr.createQuery(jpql, Services.class).setParameter("serviceid", serviceId)
				.getSingleResult();

	}

	@Override
	public Slots getSlotBySlotsId(int slotId) {

		String jpql = "select s from Slots s where s.slotId=:slotid";
		return mgr.createQuery(jpql, Slots.class).setParameter("slotid", slotId).getSingleResult();
	}

	@Override
	public List<Slots> getSlotsByIdChaire(int shopId) {

		String jpql = "select s from Slots s join fetch s.shop where s.shop.shopId=:shop_Id and s.chaireAvilable>0 order by s.slotSequence";
		List<Slots> slotlist = mgr.createQuery(jpql, Slots.class).setParameter("shop_Id", shopId)
				.getResultList();
		System.out.println("in side dao get slots by shopid and chair >0............");
		System.out.println(slotlist);
		return slotlist;
	}

	@Override
	public Slots getSlotBySlotSeqence(int slotSequence, int shopId) {

		String jpql = "select s from Slots s where s.slotSequence=:slotsequence and shopId=:shopid";
		return mgr.createQuery(jpql, Slots.class).setParameter("slotsequence", slotSequence)
				.setParameter("shopid", shopId).getSingleResult();

	}

	@Override
	public String bookAppointConfirm(Appointments appoint) {

		
		mgr.persist(appoint);
		return "Appointment Booked successfully : ID " + appoint.getAppointId();

	}

	@Override
	public void changeChaireAvailableCount(Slots s,int slotId) {

		
		Slots slot=getSlotBySlotsId(slotId);
		int oldchaires=slot.getChaireAvilable();
		int newchair=oldchaires-1;
		slot.setChaireAvilable(newchair);
		
		mgr.persist(slot);
		/*
		 * String
		 * jpql="update Slots s set s.chaireAvilable="+newchair+" where s.slotId="
		 * +slotId;
		 * sf.getCurrentSession().createQuery(jpql,Slots.class).executeUpdate();
		 */

		 
	}

}
