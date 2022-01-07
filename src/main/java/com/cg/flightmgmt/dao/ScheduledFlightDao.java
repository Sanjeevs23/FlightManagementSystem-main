package com.cg.flightmgmt.dao;

import java.math.BigInteger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Flight;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.repository.AirportRepository;
import com.cg.flightmgmt.repository.FlightRepository;
import com.cg.flightmgmt.repository.ScheduleRepository;
import com.cg.flightmgmt.repository.ScheduledFlightRepository;
import com.cg.flightmgmt.service.ScheduledFlightService;

@Service
public class ScheduledFlightDao implements ScheduledFlightService{
	@Autowired
	private ScheduledFlightRepository repo;
	
	@Autowired
	private ScheduleRepository repo1;
	
	@Autowired
	private FlightRepository repo2;
	
	@Autowired
	private AirportRepository repo3;
	
	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight flight, BigInteger scheduleId,BigInteger flightNumber) {
		Schedule schedule = repo1.getById(scheduleId);
		Flight realFlight =repo2.getById(flightNumber);
		flight.setSchedule(schedule);
		flight.setFlight(realFlight);
		return repo.save(flight);
	}
	@Override
	public List<ScheduledFlight> viewScheduledFlights(){
		return repo.findAll();
	}
	@Override
	public List<ScheduledFlight> viewScheduledFlights(int airportsourceCode, int airportDestCode, LocalDateTime depaturedate){
		List<ScheduledFlight> ans = new ArrayList<>();
		Airport source = repo3.getById(airportsourceCode);
		Airport dest = repo3.getById(airportDestCode);
		List<ScheduledFlight> list = repo.findAll();
		for(ScheduledFlight s: list) {
			if(s.getSchedule().getSourceAirport().equals(source) &&  s.getSchedule().getDestinationAirport().equals(dest) && s.getSchedule().getDepartureTime().equals(depaturedate)) {
				ans.add(s);
			}
		}
		return ans;
	}
	@Override
	public List<ScheduledFlight> viewScheduledFlight(BigInteger flightno){
		List<ScheduledFlight> ans = new ArrayList<>();
		List<ScheduledFlight> list = repo.findAll();
		for(ScheduledFlight s: list) {
			if(s.getFlight().getFlightNumber().equals(flightno)) {
				ans.add(s);
			}
		}
		return ans;
	}
	@Override
	public void deleteFlightSchedule(BigInteger flightno){
		repo.delete(repo.getById(flightno));
	}
	@Override
	public ScheduledFlight modifyFlightSchedule(ScheduledFlight flight) {
		return repo.save(flight);
	}
	@Override
	public void validateScheduledFlight(ScheduledFlight flight) {
		
	}
}
