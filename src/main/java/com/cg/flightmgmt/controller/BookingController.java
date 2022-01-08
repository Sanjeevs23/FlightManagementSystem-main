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
import org.springframework.web.bind.annotation.RequestParam;
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
	@PostMapping(path="/createBooking")
	public void createBooking(@Valid @RequestBody Booking booking, @RequestParam("Userid") int Userid, @RequestParam("ScheduleFlightid") int ScheduleFlightId) {
		BigInteger userid = BigInteger.valueOf(Userid);
		BigInteger scheduledFlightId = BigInteger.valueOf(ScheduleFlightId);
		logger.info("Booking created sucessfully");
		 dao.addBooking(booking,userid,scheduledFlightId);
	}
	
	//localhost:5010/user/deleteUser/:id
	@DeleteMapping(path="deleteBooking/{bookingid}")
	 public void deletebooking(@PathVariable int bookingid) {
		BigInteger Bookingid = BigInteger.valueOf(bookingid);
    	dao.deleteBooking(Bookingid);
    }
    
    @PutMapping("/updateBooking")
    public Booking updateBooking(@RequestBody Booking booking) {
    	return dao.modifyBooking(booking);
    }
    
    @GetMapping("/viewbooking/{bookingid}")
    public Booking getBooking(@PathVariable int bookingid) throws BookingNotFoundException {
    	BigInteger Bookingid = BigInteger.valueOf(bookingid);
    	return dao.viewBooking(Bookingid);
    }
    
    @GetMapping("/viewbooking")
    public List<Booking> getBookInList(Booking booking){
    	return dao.viewBooking();   	
    }
}
