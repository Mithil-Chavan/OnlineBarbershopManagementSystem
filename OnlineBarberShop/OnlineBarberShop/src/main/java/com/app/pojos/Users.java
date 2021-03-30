package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Users {

	private int userId;
	private String userName;
	private String emailId;
	private String password;
	private String role;
	private String location;
	private List<Appointments> appoints = new ArrayList<Appointments>();

	public Users() {

		System.out.println("Inside user constructor....");
	}

	public Users(String userName, String emailId, String password, String role, String location) {
		super();

		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		this.location = location;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// shop-service one-many Association
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Appointments> getAppoints() {
		return appoints;
	}

	public void setAppoints(List<Appointments> appoints) {
		this.appoints = appoints;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", role=" + role
				+ ", location=" + location + "]";
	}

}
