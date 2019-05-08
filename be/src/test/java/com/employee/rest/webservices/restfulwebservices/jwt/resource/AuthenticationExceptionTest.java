package com.employee.rest.webservices.restfulwebservices.jwt.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AuthenticationExceptionTest {
  
	@Test
	public void testException() {
		
		AuthenticationException authExp  = new AuthenticationException("Test", new RuntimeException());
		
		assertEquals("Test", authExp.getMessage());
	}
    
}

