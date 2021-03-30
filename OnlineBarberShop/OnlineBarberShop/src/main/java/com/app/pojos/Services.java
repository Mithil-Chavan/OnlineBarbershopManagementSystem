package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Services {
	
	private Integer serviceId;
	private String serviceName;
	private String serviceDescription;
	private double servicePrice;
	private int serviceDuration;
	private Shops shop;
	private List<Appointments>Appoints=new ArrayList<>(); 
	
	

	

	public Services() {
	System.out.println("inside service constructor....");
	}
	
	
	public Services( String serviceName, String serviceDescription, double servicePrice,
			int serviceDuration) {
		super();
	
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
		this.servicePrice = servicePrice;
		this.serviceDuration = serviceDuration;

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getServiceId() {
		return serviceId;
	}


	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	
	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}



	public String getServiceDescription() {
		return serviceDescription;
	}


	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}


	public double getServicePrice() {
		return servicePrice;
	}


	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}


	public int getServiceDuration() {
		return serviceDuration;
	}


	public void setServiceDuration(int serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	//Services to shop Association  Mapping
		@ManyToOne
		@JoinColumn(name="shopId")
	public Shops getShop() {
		return shop;
	}


	public void setShop(Shops shop) {
		this.shop = shop;
	}
	
	  //Many ToMany Association of services to Appointmets
	@LazyCollection(LazyCollectionOption.FALSE)
	  @ManyToMany(mappedBy = "services" ) 
	  public List<Appointments> getAppoints() {
	  return Appoints; }
	  
	  
	  public void setAppoints(List<Appointments> appoints) 
	  {
		  Appoints = appoints; 
	  }
	 

	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceDescription="
				+ serviceDescription + ", servicePrice=" + servicePrice + ", serviceDuration=" + serviceDuration + "]";
	}

	 
	

}
