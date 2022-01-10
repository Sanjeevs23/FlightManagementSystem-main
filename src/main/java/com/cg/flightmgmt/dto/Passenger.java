package com.cg.flightmgmt.dto;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Passenger_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Passenger {
	@Id
	private BigInteger pnrNumber;
	@NotNull(message="Passenger name should not be null")
	@NotEmpty(message="Passenger name should not be empty")
	private String passengerName;
	@NotNull(message="Passenger age should not be null")
	private int passengerAge;
	@NotNull(message="Passenger UIN should not be null")
	@Digits(integer=12, fraction=0)
	private BigInteger passengerUIN;
	private Double luggage;
	@ManyToOne
	@JoinColumn(name="bookingId")
	@JsonIgnore
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
