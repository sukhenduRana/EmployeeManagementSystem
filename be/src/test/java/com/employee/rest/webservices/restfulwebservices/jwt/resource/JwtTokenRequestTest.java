package com.employee.rest.webservices.restfulwebservices.jwt.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class  JwtTokenRequestTest {
  
 @Test
 public void testGettersAndSetters() {
	 
	 
	 JwtTokenRequest jwtReq = new JwtTokenRequest();
	 
	 jwtReq.setUsername("admin");
	 jwtReq.setPassword("admin");
	 assertEquals("admin", jwtReq.getUsername());
	 assertEquals("admin", jwtReq.getPassword());
			 
 }
}



