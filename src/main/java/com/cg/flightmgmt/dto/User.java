package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="User_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	@Id
	private BigInteger userId;
	private String userType;
	private String userName;
	private String password;
	private String email;
	private String mobileNumber;
	@OneToMany(mappedBy="userId",cascade =CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	List<Booking> bookingList = new ArrayList<>();
	public User() {
		
	}
	
	public User(BigInteger userId, String userType, String userName, String password, String email,
			String mobileNumber) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public List<Booking> getBookingList() {
		return bookingList;
	}
	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	
	public void addBooking(Booking B) {
		B.setUserId(this);
		this.getBookingList().add(B);
	}
	
	public void deletebooking(Booking B) {
		B.setUserId(this);
		BigInteger deleteid = B.getBookingId();
		for(int i=0;i<this.getBookingList().size();i++) {
			if(this.getBookingList().get(i).getBookingId().equals(deleteid)) {
				this.getBookingList().remove(i);
			}
		}
	}
}
