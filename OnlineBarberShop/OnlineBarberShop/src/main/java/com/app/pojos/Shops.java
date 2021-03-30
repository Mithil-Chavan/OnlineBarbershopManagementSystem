package com.app.pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Shops {

	private Integer shopId;
	private String shopName;
	private String ownerName;
	private String location;
	private String contactNumber;
	private double reviews;
	private boolean status;
	private List<Services> services = new ArrayList<Services>();
	private Set<Slots> slots = new HashSet<Slots>();
	private List<Appointments> appointments = new ArrayList<Appointments>();

	public Shops() {
		System.out.println("Inside Shops constructor....");

	}

	public Shops(String shopName, String ownerName, String location, String contactNumber, double reviews,
			boolean status) {
		super();

		this.shopName = shopName;
		this.ownerName = ownerName;
		this.location = location;
		this.contactNumber = contactNumber;
		this.reviews = reviews;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public double getReviews() {
		return reviews;
	}

	public void setReviews(double reviews) {
		this.reviews = reviews;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// shop-service one-many Association
	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy = "shop", orphanRemoval = true)
	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	// shop-slot one-many Association
	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Slots> getSlots() {
		return slots;
	}

	public void setSlots(Set<Slots> slots) {
		this.slots = slots;
	}

	// shop-Appointments one-many Association
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Appointments> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointments> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Shops [shopId=" + shopId + ", shopName=" + shopName + ", location=" + location + ", contactNumber="
				+ contactNumber + ", reviews=" + reviews + ", status=" + status + "]";
	}

}
