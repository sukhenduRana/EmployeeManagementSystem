package com.employee.rest.webservices.restfulwebservices.jwt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JwtUserDetailsTest {

  @Test
  public void testUserDetails() {
	  
	  JwtUserDetails user = new JwtUserDetails(1l, "admin", "admin", "test");
	  
	  assertEquals("admin", user.getUsername());
	  assertEquals("admin", user.getPassword());
	  assertEquals(1l, user.getId().longValue());
  }

}



