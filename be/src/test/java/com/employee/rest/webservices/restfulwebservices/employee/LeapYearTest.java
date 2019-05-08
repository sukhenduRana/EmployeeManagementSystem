package com.employee.rest.webservices.restfulwebservices.employee;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.employee.rest.webservices.restfulwebservices.model.LeapYear;

public class LeapYearTest {
	
	@Test
	public void testLeapYear() {
	
	 assertEquals(false, LeapYear.isLeapYear(2019));
	 assertEquals(true, LeapYear.isLeapYear(2020));

	 
	}

}
