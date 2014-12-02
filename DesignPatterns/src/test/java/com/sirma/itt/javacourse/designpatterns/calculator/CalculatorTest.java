package com.sirma.itt.javacourse.designpatterns.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link CalculatorTest} contains test for the methods of the class {@link Calculator}.
 */
public class CalculatorTest {
	private Calculator calculator = new Calculator();
	private String firstInput = "6+5";
	private String secondInput = "6.33+5^2";
	private String thirdInput = "6.33+5^2.5";
	private String allOperations = "6.33+5^2-9/3*2";

	/**
	 * Tests the method getValue of the class {@link Calculator} with a string containing two
	 * integers.
	 */
	@Test
	public void testTwoIntegers() {
		String expected = "11.0";
		String actual = calculator.getDetails(firstInput);
		assertEquals(expected, actual);
	}

	/**
	 * Tests the method getValue of the class {@link Calculator} with a string containing two
	 * operations, the second one having priority.
	 */
	@Test
	public void testTwoOperations() {
		String expected = "31.33";
		String actual = calculator.getDetails(secondInput);
		assertEquals(expected, actual);
	}

	/**
	 * Tests the method getValue of the class {@link Calculator} with a string containing two
	 * operations, the second one having priority.
	 */
	@Test(expected = NumberFormatException.class)
	public void testFloatPower() {
		calculator.getDetails(thirdInput);
	}

	/**
	 * Tests the method getValue of the class {@link Calculator} with a string containing all
	 * permitted operations.
	 */
	@Test
	public void testAllOperations() {
		String expected = "25.33";
		String actual = calculator.getDetails(allOperations);
		assertEquals(expected, actual);
	}

}
