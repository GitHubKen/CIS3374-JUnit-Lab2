package com.lab2.transit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class lab2test {

	private static final double DELTA = 1e-15;

	private double expected;
	private int age;
	private String time;
	private boolean isHoliday;

	public lab2test(double expected, int age, String time, boolean isHoliday) {	//This is the constructor
		this.expected = expected;
		this.age = age;
		this.time = time;
		this.isHoliday = isHoliday;
	}

	@Parameters
	public static Collection<Object[]> testParams() {
		return Arrays.asList(new Object[][] {
				{0.0, 4, "6:59", false},
				{0.0, 4, "7:00", true},
				{0.0, 4, "9:00", true},
				{0.0, 4, "9:01", false},
				{2.5, 4, "7:00", false},
				{2.5, 4, "9:00", false},
				
				{0.0, 5, "6:59", false},
				{0.0, 5, "7:00", true},
				{0.0, 5, "9:00", true},
				{0.0, 5, "9:01", true},
				{2.5, 5, "7:00", false},
				{2.5, 5, "9:00", false},
			
				{2.5, 6, "6:59", false},
				{2.5, 6, "7:00", true},
				{2.5, 6, "7:00", false},
				{2.5, 6, "7:01", true},
				{2.5, 6, "9:00", false},
				{2.5, 6, "9:00", true},

				{0.0, 65, "9:00", true},
				{0.0, 65, "9:01", false},
				{0.0, 65, "7:00", true},
				{0.0, 65, "6:59", true},
				{2.5, 65, "9:00", false},
				{2.5, 65, "7:00", false},
				
				{0.0, 66, "6:59", true},
				{0.0, 66, "7:00", true},
				{0.0, 66, "9:01", true},
				{2.5, 66, "7:00", false},
				{2.5, 66, "7:01", false},
				{2.5, 66, "9:00", false},
		});
	}
	
	@Test
	public void calculateFareTest() {
		assertEquals(expected, FareCalculator.calculateFare(age, time, isHoliday), DELTA);	
	}

}