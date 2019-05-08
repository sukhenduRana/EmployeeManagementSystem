package com.employee.rest.webservices.restfulwebservices.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.rest.webservices.restfulwebservices.jpa.EmployeeJPARepository;
import com.employee.rest.webservices.restfulwebservices.model.Employee;

public class EmployeeResourceTest {
	
	@Autowired
	EmployeeResource eRes;
	
	@Mock
	private EmployeeJPARepository empRep;
	 
	
	
	@Test
	public void testCreate() {
		
		Employee e = new Employee();
		e.setId(30l);
		eRes.createEmployee("admin", e);
	}
	
	@Test
	public void testGetAllEmployees() {
		
		List<Employee> empList = eRes.getAllEmployees("admin");
		assertEquals(false, empList.isEmpty()); 
	}
}
