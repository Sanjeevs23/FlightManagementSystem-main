package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="Booking_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking {
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger bookingId;
	@ManyToOne
	@JoinColumn(name ="userId")
	private User userId;
	private LocalDate bookingDate;
	@OneToMany(mappedBy="booked",cascade =CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	private List <Passenger>passengerList = new ArrayList<>();
	private double ticketCost;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "scheduleFlightId")
	private ScheduledFlight flight;
	private int noOfPassangers;
	public BigInteger getBookingId() {
		return bookingId;
	}
	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	public double getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	public ScheduledFlight getFlight() {
		return flight;
	}
	public void setFlight(ScheduledFlight flight) {
		this.flight = flight;
	}
	public int getNoOfPassangers() {
		return noOfPassangers;
	}
	public void setNoOfPassangers(int noOfPassangers) {
		this.noOfPassangers = noOfPassangers;
	}
	public void addPassenger(Passenger P) {
		P.setBooked(this);
		this.getPassengerList().add(P);
	}
	public void deletePassenger(Passenger P) {
		P.setBooked(this);
		BigInteger delid = P.getPnrNumber();
		for(int i=0;i<this.getPassengerList().size();i++) {
			if(this.getPassengerList().get(i).getPnrNumber().equals(delid)) {
				this.getPassengerList().remove(i);
			}
		}
		
	}
}
