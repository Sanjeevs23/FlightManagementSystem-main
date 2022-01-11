package com.cg.flightmgmt.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.dao.ScheduleDao;
import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.Schedule;
import com.cg.flightmgmt.repository.AirportRepository;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
		Logger logger=org.slf4j.LoggerFactory.getLogger(ScheduleController.class);
		
		@Autowired
		private ScheduleDao dao;
		
		@Autowired
		private AirportRepository arpt;
		
		//localhost:5010/schedule/createSchedule
		@PostMapping(path="/createSchedule")
		public void createSchedule(@Valid @RequestBody Schedule schedule, @RequestParam("sourceAirportCode") int sourceAirportCode, @RequestParam("destinationAirportCode") int destinationAirportCode) {
			Airport source = arpt.getById(sourceAirportCode);
			System.out.println(source.toString());
			Airport destination =arpt.getById(destinationAirportCode);
			schedule.setSourceAirport(source);
			System.out.println(destination.toString());
			schedule.setDestinationAirport(destination);
			System.out.println(schedule.toString());
			logger.info("Booking created sucessfully");
			 dao.createSchedule(schedule);
		}
		
}
