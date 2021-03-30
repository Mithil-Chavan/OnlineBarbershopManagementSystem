package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface IShopkeeperDao {
	
	String addService(Services s);
	String removeService(int serviceId);
	String addSlot(Slots s);
	String removeSlot(int slotId);
	String updateService(int serviceId,Services s);
	String UpdateSlot(int slotId,Slots s);
	List<Appointments> appointmetsList(String ownerName);
	Shops getShopByOwnerName(String ownerName);
	List<Services>getServiceList(String ownerName);
	List<Slots> getSlotsList(String ownerName);
	Services getServicesByServiceId(int serviceId);
	Slots getSlotBySlotsId(int slotId);
	String updateService(Services s);
	String updateSlot(Slots s);

}
