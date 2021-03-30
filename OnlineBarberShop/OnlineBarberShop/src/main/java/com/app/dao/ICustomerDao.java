package com.app.dao;

import java.util.List;

import com.app.pojos.Appointments;
import com.app.pojos.Services;
import com.app.pojos.Shops;
import com.app.pojos.Slots;

public interface ICustomerDao {
	
	String bookAppointment();
	List<Appointments> viewAppointments(int userId);
	String feedbackSubmit(int shopId);
	List<String>getShopsLocations();
	List<Shops> getShopsByLocations(String location);
	List<Services> getServicesById(int shopId);	
	List<Slots> getSlotsById(int shopId);
	Shops getShopByShopId(int shopId);
	Services getServicesByServiceId(int serviceId);
	Slots getSlotBySlotsId(int slotId);
	List<Slots> getSlotsByIdChaire(int shopId);
	Slots getSlotBySlotSeqence(int slotSequence,int shopId);
	String bookAppointConfirm(Appointments appoint);
	void changeChaireAvailableCount(Slots s,int slotId);
}
