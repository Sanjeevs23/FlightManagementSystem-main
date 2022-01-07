package com.cg.flightmgmt.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.flightmgmt.dto.Schedule;

import com.cg.flightmgmt.repository.ScheduleRepository;
import com.cg.flightmgmt.service.ScheduleService;

public class ScheduleDao implements ScheduleService {
	
	@Autowired
	private ScheduleRepository rep;

	@Override
	public Schedule createSchedule(	Schedule schedule) {
		return rep.save(schedule);
	}



}
