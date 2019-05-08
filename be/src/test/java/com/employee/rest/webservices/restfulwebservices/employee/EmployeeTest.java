package com.employee.rest.webservices.restfulwebservices.employee;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.employee.rest.webservices.restfulwebservices.model.Employee;


public class EmployeeTest{
	
	@Test
	public void testGettersAndSetters() {
		final Date date = new Date("27/10/1989");
		Employee emp = new Employee();
		Employee emp2 = new Employee(3L, "Test", "Test2", "Male", date, "Test", 33);
		
		
		emp.setFisrt_Name("Sukhendu");
		emp.setLast_Name("Rana");
		emp.setId(1L);
		emp.setDept("CIB");
		emp.setDob(date);
		emp.setGender("male");
		
		assertEquals("Sukhendu", emp.getFirst_Name());
		assertEquals("Rana", emp.getLast_Name());
		assertEquals(1L, emp.getId().longValue());
		assertEquals("CIB", emp.getDept());
		assertEquals(date, emp.getDob());
		assertEquals("male", emp.getGender());
		assertEquals(false, emp.equals(emp2));
	}
	
	@Test
	public void testSortedEmployees() {
		
		final Date date1 = new Date("27/10/1989");
		final Date date2 = new Date("27/10/1990");
		
		Employee emp1 = new Employee(3L, "ABC", "Test2", "Male", date1, "Test", 33);
		Employee emp2 = new Employee(4L, "ABC", "Test2", "Male", date2, "Test", 33);
		
		
		List<Employee> list  = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		
		Collections.sort(list);
		
		assertEquals(date2, list.get(0).getDob());
		
		
	}
}