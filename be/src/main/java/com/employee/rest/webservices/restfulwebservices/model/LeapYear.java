package com.employee.rest.webservices.restfulwebservices.model;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int year = scan.nextInt();
		
		System.out.println(isLeapYear(year));
		
		
		

	}
	
	public static boolean isLeapYear(int val) {
		
		if(val % 4 == 0) {
			return true;
		}
		
		return false;
	}

}
