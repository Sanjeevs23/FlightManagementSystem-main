package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
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
Logger logger=org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ScheduledFlightDao dao;
	
	@PostMapping(path="/addScheduleFlight")
	public ScheduledFlight createBooking(@Valid @RequestBody ScheduledFlight flight, @RequestParam("Scheduleid") BigInteger Scheduleid,@RequestParam("FlightId")BigInteger FlightId) {
		return dao.addScheduleFlight(flight, Scheduleid, FlightId);
	}
	
	@GetMapping(path="/viewScheduledFlights")
	public List<ScheduledFlight> viewScheduledFlight(){
		return dao.viewScheduledFlights() ;
		
	}
	
	@GetMapping(path="/viewScheduledflights")
	public List<ScheduledFlight> viewScheduledFlights(@RequestParam int airportsourceCode, @RequestParam int airportDestCode, @RequestParam LocalDateTime depaturedate){
		return dao.viewScheduledFlights(airportsourceCode, airportDestCode, depaturedate);
		
	}
	
	@GetMapping(path="/viewScheduledFlight/{flightNumber}")
	public List<ScheduledFlight> viewScheduledFlight(@PathVariable BigInteger flightno){
		return dao.viewScheduledFlight(flightno);
	}
	
	@PostMapping(path="/UpdateModifyFlightSchedule")
	public ScheduledFlight modifyFlightSchedule(@RequestBody ScheduledFlight flight) {
		return dao.modifyFlightSchedule(flight);
	}
}
