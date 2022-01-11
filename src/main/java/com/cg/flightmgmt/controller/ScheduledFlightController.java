package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dao.ScheduledFlightDao;
import com.cg.flightmgmt.dto.ScheduledFlight;


@RestController
@RequestMapping("/scheduledFlightController")
public class ScheduledFlightController {
Logger logger=org.slf4j.LoggerFactory.getLogger(ScheduledFlightController.class);
	
	@Autowired
	private ScheduledFlightDao dao;
	
	@PostMapping(path="/addScheduleFlight")
	public ScheduledFlight createBooking(@Valid @RequestBody ScheduledFlight flight, @RequestParam("Scheduleid") int Scheduleid,@RequestParam("FlightId") int FlightId) {
		BigInteger scheduleid = BigInteger.valueOf(Scheduleid);
		BigInteger flightid = BigInteger.valueOf(FlightId);
		System.out.println(scheduleid);
		System.out.println(flightid);
		System.out.println(flight);
		logger.info("Scheduler flight added sucessfully");
	return dao.addScheduleFlight(flight, scheduleid, flightid);
		//return null;
	}
	
	@GetMapping(path="/viewScheduledFlights")
	public List<ScheduledFlight> viewScheduledFlight(){
		logger.info("all flight retrieved sucessfully");
		return dao.viewScheduledFlights() ;
		
	}
	
	@GetMapping(path="/viewScheduledflights")
	public List<ScheduledFlight> viewScheduledFlights(@RequestParam("airportsourceCode") int airportsourceCode, @RequestParam("airportDestCode") int airportDestCode, @RequestParam("depaturedate") String depaturedate){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime DepartureDate = LocalDateTime.parse(depaturedate, formatter);

		//System.out.println(depaturedate);
		logger.info("Scheduled Flights Retrived sucessfully");
		return dao.viewScheduledFlights(airportsourceCode, airportDestCode, DepartureDate);
		//return null;
		
	}
	
	@GetMapping(path="/viewScheduledFlight/{flightNumber}")
	public List<ScheduledFlight> viewScheduledFlight(@PathVariable int flightNumber){
		BigInteger flightno= BigInteger.valueOf(flightNumber);
		logger.info("Scheduled Flight Retrived sucessfully");
		return dao.viewScheduledFlight(flightno);
	}
	
	@PostMapping(path="/UpdateModifyFlightSchedule")
	public ScheduledFlight modifyFlightSchedule(@RequestBody ScheduledFlight flight) {
		logger.info("Scheduled Flights Updated sucessfully");
		return dao.modifyFlightSchedule(flight);
	}
}
