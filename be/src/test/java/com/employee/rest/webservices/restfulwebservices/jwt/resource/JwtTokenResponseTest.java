package com.employee.rest.webservices.restfulwebservices.jwt.resource;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JwtTokenResponseTest {

  @Test
  public void testGettersSetters() {
	  
	  
	  JwtTokenResponse jwtRep = new JwtTokenResponse("abc");
	  
	  assertEquals("abc", jwtRep.getToken());
  }
}



