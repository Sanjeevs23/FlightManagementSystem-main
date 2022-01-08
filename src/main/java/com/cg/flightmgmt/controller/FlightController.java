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

import com.cg.flightmgmt.dao.FlightDao;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.exception.FlightNotFoundException;

@RestController
@RequestMapping("/flight")
public class FlightController {
Logger logger=org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private FlightDao dao;
	
	//localhost:5010/flight/createFirst
	@PostMapping(path="/createFlight")
	public Flight createFlight(@Valid @RequestBody Flight flight) {
		logger.info("Flight created sucessfully");
		return dao.addFlight(flight);
	}
	
	//localhost:5010/flight/flights
	@RequestMapping(path="/flights")
	public List<Flight> viewAllFlights(){
		return dao.viewFlight();
	}
	
	//localhost:5010/flight/flights/:id
	@GetMapping(path="/flights/{Flightno}")
	public Flight viewFlightById(@PathVariable int Flightno) throws FlightNotFoundException{
		BigInteger flightno = BigInteger.valueOf(Flightno);
		return dao.viewFlight(flightno);
	}
	
	//localhost:5010/flight/updateFlight/:id
	@PutMapping(path="/UpdateFlight")
	public Flight updateFlight(@RequestBody Flight flight) {
		return dao.modifyFlight(flight);
	}
	
	//localhost:5010/flight/deleteFlight/:id
	@DeleteMapping(path="deleteFlight/{Flightno}")
	public void deleteFlight(@PathVariable int Flightno){
		BigInteger flightno = BigInteger.valueOf(Flightno);
		dao.deleteFlight(flightno);
	}
}
