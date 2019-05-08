package com.employee.rest.webservices.restfulwebservices.jwt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtInMemoryUserDetailsServiceTest{

 @Test
 public void test() {
	 JwtInMemoryUserDetailsService ser = new JwtInMemoryUserDetailsService();
	 UserDetails user =  ser.loadUserByUsername("admin");
	 
	 assertEquals("admin", user.getUsername());
	 
 }

}



