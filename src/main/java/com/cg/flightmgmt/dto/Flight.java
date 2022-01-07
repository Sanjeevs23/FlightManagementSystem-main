package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Flight_table")
public class Flight {
	@Id
	private BigInteger flightNumber;
	private String carrierName;
	private String flightModel;
	private int seatCapacity;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(BigInteger flightNumber, String carrierName, String flightModel, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}
	public BigInteger getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(BigInteger flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
}
