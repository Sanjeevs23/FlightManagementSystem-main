package com.cg.flightmgmt.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Airport_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Airport {
	@Id
	@NotNull(message = "Airport Code should not be Empty")
	private int airportCode;
	@Pattern(regexp="[a-zA-z ]*",message="Airport Name should have only alphabets")
	@NotNull(message="Airport Name should not be Empty")
	@Size(min=3,message="Airport Name should have minimum 3 alphabets")
	private String airportName;
	@NotNull(message="Airport Location should not be Empty")
	@Size(min=3,message="Airport Location should have minimum 3 alphabets")
	private String airportLocation;
	
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airport(int airportCode, String airportName, String airportLocation) {
		super();
		this.airportCode = airportCode;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	
	public int getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(int airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	
	@Override
	public String toString() {
		return "Airport <" + "airportName='" + airportName + '\'' + ", airportLocation='" + airportLocation + '\''
				+ ", airportCode='" + airportCode + '\'' + '>';
	}
}
