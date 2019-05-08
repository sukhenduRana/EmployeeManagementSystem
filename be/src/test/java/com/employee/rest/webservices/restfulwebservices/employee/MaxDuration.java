package com.employee.rest.webservices.restfulwebservices.employee;

import java.util.Collections;
import java.util.List;

public class MaxDuration {

	public static String findMax(List<String> l) {
	
		if(l != null && !l.isEmpty())
		{
			Collections.sort(l);
			return l.get(l.size()-1);
		}
		
		return "Empty list";
	}
}
