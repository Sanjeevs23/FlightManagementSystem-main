package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Passenger_table")
public class Passenger {
	@Id
	private BigInteger pnrNumber;
	private String passengerName;
	private int passengerAge;
	private BigInteger passengerUIN;
	private Double luggage;
	@ManyToOne
	@JoinColumn(name="bookingId")
	private Booking booked;
	
	public BigInteger getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public Double getLuggage() {
		return luggage;
	}
	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}
	public Booking getBooked() {
		return booked;
	}
	public void setBooked(Booking booked) {
		this.booked = booked;
	}
	
}
