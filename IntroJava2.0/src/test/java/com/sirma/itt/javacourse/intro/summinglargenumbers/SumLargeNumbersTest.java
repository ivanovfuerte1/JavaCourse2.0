package com.sirma.itt.javacourse.intro.summinglargenumbers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class implements tests for Summing large numbers.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class SumLargeNumbersTest {

	/**
	 * Tests the method sumLargeNumbers for Large numbers with sample values.
	 */
	@Test
	public void test1() {
		String firstNumberToTest = "123123123123123000123123123123123";
		String secondNumberToTest = "111111222222333000111111222222333";
		String expectedResult = "234234345345456000234234345345456";
		String result = new SummingLargeNumbers().sumLargeNumbers(firstNumberToTest,
				secondNumberToTest);
		assertEquals(expectedResult, result);
	}

	/**
	 * Tests the method sumLargeNumbers for Large numbers with different values.
	 */
	@Test
	public void test2() {
		String firstNumberToTest = "925";
		String secondNumberToTest = "11178";
		String expectedResult = "12103";
		String result = new SummingLargeNumbers().sumLargeNumbers(firstNumberToTest,
				secondNumberToTest);
		assertEquals(expectedResult, result);
	}

}
