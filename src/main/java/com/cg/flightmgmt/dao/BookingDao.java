package com.cg.flightmgmt.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.dto.Passenger;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.BookingNotFoundException;
import com.cg.flightmgmt.repository.BookingRepository;
import com.cg.flightmgmt.repository.ScheduledFlightRepository;
import com.cg.flightmgmt.repository.UserRepository;
import com.cg.flightmgmt.service.BookingService;

@Service
public class BookingDao implements BookingService {
	@Autowired
	private BookingRepository repo;

	@Autowired
	private UserRepository repo1;

	@Autowired
	private ScheduledFlightRepository repo2;

	@Override
	public void addBooking(Booking booking, BigInteger UserId, BigInteger flightId) {
		User addBooker = repo1.getById(UserId);
		ScheduledFlight currentflight = repo2.getById(flightId);
		booking.setFlight(currentflight);
		int nPassengers= booking.getPassengerList().size();
		booking.setNoOfPassangers(nPassengers);
		if (this.validateBooking(booking) == true) {
			int balence = booking.getFlight().getAvailableSeats() - booking.getNoOfPassangers();
			for(int i=0;i<booking.getPassengerList().size();i++) {
				booking.getPassengerList().get(i).setBooked(booking);
			}
			addBooker.addBooking(booking);
			booking.getFlight().setAvailableSeats(balence);
			repo2.save(booking.getFlight());
		}
		repo1.save(addBooker);
	}

	@Override
	public void deleteBooking(BigInteger bookingid) {
		Booking del = repo.getById(bookingid);
		User deleteBooker = del.getUserId();
		deleteBooker.deletebooking(del);
		repo1.save(deleteBooker);
	}

	@Override
	public Booking modifyBooking(Booking booking) {
		return repo.save(booking);
	}

	@Override
	public Booking viewBooking(BigInteger bookingid) throws BookingNotFoundException {
		Optional<Booking> found = repo.findById(bookingid);
		if (found.isPresent()) {
			return found.get();
		} else {
			throw new BookingNotFoundException("This booking does not exist");
		}
	}

	@Override
	public List<Booking> viewBooking() {
		return repo.findAll();
	}

	@Override
	public boolean validateBooking(Booking booking) {
		boolean res = false;
		ScheduledFlight sf = booking.getFlight();
		int pass = booking.getNoOfPassangers();
		int seatsavailable = sf.getAvailableSeats();
		if (pass <= seatsavailable) {
			res = true;
		}
		return res;
	}

	@Override
	public void validatePassenger(Passenger passenger) {

	}
}
