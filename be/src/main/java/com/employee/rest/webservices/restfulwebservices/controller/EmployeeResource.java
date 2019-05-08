package com.employee.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.rest.webservices.restfulwebservices.jpa.EmployeeJPARepository;
import com.employee.rest.webservices.restfulwebservices.model.Employee;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeResource {
	
	@Autowired
	private EmployeeJPARepository empJPARepository;
	
	@GetMapping("/jpa/users/{username}/employees")
	public List<Employee> getAllEmployees(@PathVariable String username){
		
		return empJPARepository.findAll().stream().sorted().collect(Collectors.toList());
		
	} 
	
	@PostMapping("/jpa/users/{username}/employees")
	public ResponseEntity<Void> createEmployee(@PathVariable String username, @RequestBody Employee emp){
		 Employee createEmp = empJPARepository.save(emp);
		 URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createEmp.getId()).toUri();
		 
		 return ResponseEntity.created(uri).build();
	}
	
	/* 
	 * @DeleteMapping("/jpa/users/{username}/employees/{id}") public
	 * ResponseEntity<Void> deleteEmployee(@PathVariable String
	 * username, @PathVariable long id){
	 *  
	 * empJPARepository.deleteById(id); return ResponseEntity.noContent().build(); }
	 * 
	 * @GetMapping("/jpa/users/{username}/employees/{id}") public Employee
	 * getEmployee(@PathVariable String username, @PathVariable long id) {
	 * 
	 * return empJPARepository.findById(id).get(); }
	 * 
	 * @PutMapping("/jpa/users/{username}/employees/{id}") public
	 * ResponseEntity<Employee> updateEmployee(@PathVariable String
	 * username, @PathVariable long id, @RequestBody Employee emp){ Employee
	 * updatedEmp = empJPARepository.save(emp); return new
	 * ResponseEntity<Employee>(updatedEmp, HttpStatus.OK); }
	 */
	
	
}
