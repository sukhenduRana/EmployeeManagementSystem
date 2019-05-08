package com.employee.rest.webservices.restfulwebservices.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.rest.webservices.restfulwebservices.model.Employee;

@Repository
public interface EmployeeJPARepository extends JpaRepository<Employee, Long>{

	List<Employee> findAll();
	
}
