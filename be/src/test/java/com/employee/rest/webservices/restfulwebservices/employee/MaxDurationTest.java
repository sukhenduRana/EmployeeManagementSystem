package com.employee.rest.webservices.restfulwebservices.employee;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MaxDurationTest {
	
	@Test
	public void testMaxDuration() {
		
		
		List<String> listDrations = new ArrayList<>();
		listDrations.add("5Y3M2D");
		listDrations.add("1Y1M1D");
		listDrations.add("3Y2M1D");
		
		assertEquals("5Y3M2D", MaxDuration.findMax(listDrations));
	}

}
