package com.sirma.itt.javacourse.intro.gcd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class tests the methods for finding greatest common divisor and least common multiple of the
 * class GCDAndLCM.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class GCDAndLCMTest {

	/**
	 * Tests the method findGCD.
	 */
	@Test
	public void test1() {
		int result = new GCDAndLCM().findGCD(6, 10);
		assertEquals(2, result);
	}

	/**
	 * Tests the method findGCD with different values.
	 */
	@Test
	public void test2() {
		int result = new GCDAndLCM().findGCD(27, 162);
		assertEquals(27, result);
	}

	/**
	 * Tests the method findGCD with two equal numbers.
	 */
	@Test
	public void test3() {
		int result = new GCDAndLCM().findGCD(27, 27);
		assertEquals(27, result);
	}

	/**
	 * Tests the method findGCD with a positive number and zero.
	 */
	@Test
	public void test4() {
		int result = new GCDAndLCM().findGCD(27, 0);
		assertEquals(27, result);
	}

	/**
	 * Tests the method findGCD with two zeroes assuming the result is zero.
	 */
	@Test
	public void test5() {
		int result = new GCDAndLCM().findGCD(0, 0);
		assertEquals(0, result);
	}

	/**
	 * Tests the method findGCD with two prime numbers.
	 */
	@Test
	public void test6() {
		int result = new GCDAndLCM().findGCD(3, 5);
		assertEquals(1, result);
	}

	/**
	 * Tests the method findGCD with two prime numbers, one of them negative.
	 */
	@Test
	public void test7() {
		int result = new GCDAndLCM().findGCD(-3, 5);
		assertEquals(1, result);
	}

	/**
	 * Tests the method findGCD with two negative numbers.
	 */
	@Test
	public void test8() {
		int result = new GCDAndLCM().findGCD(-15, -25);
		assertEquals(5, result);
	}

	/**
	 * Tests the method findLCM with two positive numbers.
	 */
	@Test
	public void test9() {
		int result = new GCDAndLCM().findLCM(15, 25);
		assertEquals(75, result);
	}

	/**
	 * Tests the method findLCM with a positive number and zero.
	 */
	@Test(expected = ArithmeticException.class)
	public void test10() {
		new GCDAndLCM().findLCM(0, 25);
	}

}