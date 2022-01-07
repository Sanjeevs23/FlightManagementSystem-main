package com.cg.flightmgmt.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Airport_table")
public class Airport {
	@Id
	private int airportCode;
	private String airportName;
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
