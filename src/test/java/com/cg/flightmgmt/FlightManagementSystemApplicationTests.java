package com.cg.flightmgmt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.flightmgmt.dao.AirportDao;
import com.cg.flightmgmt.dto.Airport;

@SpringBootTest
class FlightManagementSystemApplicationTests {
	@Autowired
	@Mock
	private AirportDao dao;

	@Test
	public void testAddAirportMethod() {
		
	        Airport a = new Airport(1010, "XYZ Airport", "ABC");
		Airport check = dao.addAirport(a);
	        assertEquals(a.getAirportCode(), check.getAirportCode());
	        assertEquals(a.getAirportName(), check.getAirportName());
	        assertEquals(a.getAirportLocation(), check.getAirportLocation());
	}

}
