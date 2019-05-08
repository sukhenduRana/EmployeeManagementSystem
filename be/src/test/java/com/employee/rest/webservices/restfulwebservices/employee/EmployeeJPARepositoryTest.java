package com.employee.rest.webservices.restfulwebservices.employee;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.rest.webservices.restfulwebservices.jpa.EmployeeJPARepository;
import com.employee.rest.webservices.restfulwebservices.model.Employee;

public class EmployeeJPARepositoryTest{
	
	@Autowired
	private EmployeeJPARepository empJPARepository;

	@Test
	public void testFindAll() {
		
		List<Employee> empList = empJPARepository.findAll();
		
		assertEquals("Sukhendu", empList.get(0).getFirst_Name());
		
	}
	
}


