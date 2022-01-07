package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dao.BookingDao;
import com.cg.flightmgmt.dto.Booking;
import com.cg.flightmgmt.exception.BookingNotFoundException;

@RestController
@RequestMapping("/booking")
public class BookingController {
	Logger logger=org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private BookingDao dao;
	

	
	//localhost:5010/booking/createBooking
	@PostMapping(path="/createBooking/{Userid}/{ScheduleFlightId}")
	public void createBooking(@Valid @RequestBody Booking booking, @PathVariable BigInteger Userid, @PathVariable BigInteger ScheduleFlightId) {
		logger.info("Booking created sucessfully");
		 dao.addBooking(booking,Userid,ScheduleFlightId);
	}
	
	//localhost:5010/user/deleteUser/:id
	@DeleteMapping(path="deleteBooking/{id}")
	 public void deletebooking(@PathVariable BigInteger bookingid) {
    	dao.deleteBooking(bookingid);
    }
    
    @PutMapping("/updateBooking")
    public Booking updateBooking(@RequestBody Booking booking) {
    	return dao.modifyBooking(booking);
    }
    
    @GetMapping("/viewbooking/{id}")
    public Booking getBooking(@PathVariable BigInteger bookingid) throws BookingNotFoundException {
    	return dao.viewBooking(bookingid);
    }
    
    @GetMapping("/viewbooking")
    public List<Booking> getBookInList(Booking booking){
    	return dao.viewBooking();   	
    }
}
