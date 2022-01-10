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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="User_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	@Id
	private BigInteger userId;
	@NotNull(message="User type should not be null")
	private String userType;
	@NotNull(message="User name should not be null")
	@NotEmpty(message="User name should not be empty")
	@Size(min=3,max=30,message="Username has min 3 and max 30 characters")
	private String userName;
	@NotNull(message="Password should not be null")
	@NotEmpty(message="Password is mandatory and should not be empty")
	private String password;
	@NotEmpty(message="Email is mandatory should not be empty")
	@Email(message="Email is not valid")
	private String email;
	@NotNull(message="Mobile Number should not be null")
	@Pattern(regexp="[1-9][0-9]{9}",message="Please enter valid phone number, phone number should be of 10 numeric digits and not start with 0")
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
