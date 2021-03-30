package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Slots {

	private Integer slotId;
	private String slotName;
	private Integer slotSequence;
	private String slotTime;
	private int chaireAvilable;
	private Shops shop;
	private List<Appointments> Appoints = new ArrayList<>();

	public Slots() {
		System.out.println("Inside slots constructor....");
	}

	public Slots(String slotName, String slotTime, Integer chaireAvilable, Shops shop,int slotSequence) {
		super();

		this.slotName = slotName;
		this.slotTime = slotTime;
		this.chaireAvilable = chaireAvilable;
		this.shop = shop;
		this.slotSequence=slotSequence;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSlotId() {
		return slotId;
	}

	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public String getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	public Integer getChaireAvilable() {
		return chaireAvilable;
	}

	public void setChaireAvilable(Integer chaireAvilable) {
		this.chaireAvilable = chaireAvilable;
	}
	

	public Integer getSlotSequence() {
		return slotSequence;
	}

	public void setSlotSequence(Integer slotSequence) {
		this.slotSequence = slotSequence;
	}

	public void setChaireAvilable(int chaireAvilable) {
		this.chaireAvilable = chaireAvilable;
	}

	// slots to shop Association Mapping
	@ManyToOne
	@JoinColumn(name = "shopId")
	public Shops getShop() {
		return shop;
	}

	public void setShop(Shops shop) {
		this.shop = shop;
	}

	// Many ToMany Association of slots to Appointmets
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "slots")
	public List<Appointments> getAppoints() {
		return Appoints;
	}

	public void setAppoints(List<Appointments> appoints) {
		Appoints = appoints;
	}

	@Override
	public String toString() {
		return "Slots [slotId=" + slotId + ", slotName=" + slotName + ", slotTime=" + slotTime + ", chaireAvilable="
				+ chaireAvilable + "]";
	}

}
