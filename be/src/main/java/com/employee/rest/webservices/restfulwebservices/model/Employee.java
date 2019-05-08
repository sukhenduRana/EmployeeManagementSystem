package com.employee.rest.webservices.restfulwebservices.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="employee")
public class Employee implements Comparable{
	
	@Id
	@GeneratedValue
	private Long id;
	private String first_Name;
	private String last_Name;
	private String gender;
	private Date dob;
	private String dept;
	private Integer age;
	
	public Employee() {}
	public Employee(Long id, String fName, String lName, String gender, Date dob, String dept, Integer age) {
		super();
		this.id = id;
		this.first_Name = fName;
		this.last_Name = lName;
		this.gender = gender;
		this.dob = dob;
		this.dept = dept;
		this.age = age;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFisrt_Name(String username) {
		this.first_Name = username;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String description) {
		this.last_Name = description;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date targetDate) {
		this.dob = targetDate;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public int compareTo(Object o) {
		
		int val=0;
		
		if(o != null) {
			Employee e = (Employee)o;
			
			if(this.getFirst_Name().compareTo(e.getFirst_Name()) >0) {
				val = 1;
			}
			else if(this.getFirst_Name().compareTo(e.getFirst_Name()) <0) {
				val = -1;
			}

			if(val ==0) {
				if(this.getDob().after(e.getDob())) {
					val = -1;
				}
				else if(this.getDob().before(e.getDob())) {
					val = 1;
				}
			}
		}
		return val;
	}	
}
