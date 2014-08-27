package com.sirma.itt.javacourse.intro.gcd;

/**
 * The GCDAndLCM class contains methods for finding the greatest common divisor and the least common
 * multiple.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class GCDAndLCM {

	/**
	 * Finds the greatest common divisor of two integers.
	 * 
	 * @param firstInteger
	 *            the first integer from the input
	 * @param secondInteger
	 *            the second integer from the input
	 * @return the resulting greatest common divisor
	 */
	public int findGCD(int firstInteger, int secondInteger) {
		if (firstInteger == 0) {
			return Math.abs(secondInteger);
		} else if (secondInteger == 0) {
			return Math.abs(firstInteger);
		}
		int firstIntegerTemp = Math.abs(firstInteger);
		int secondIntegerTemp = Math.abs(secondInteger);
		while (firstIntegerTemp != secondIntegerTemp) {
			if (firstIntegerTemp > secondIntegerTemp) {
				firstIntegerTemp -= secondIntegerTemp;
			} else {
				secondIntegerTemp -= firstIntegerTemp;
			}
		}
		return firstIntegerTemp;
	}

	/**
	 * Finds the least common multiple of two integers.
	 * 
	 * @param firstInteger
	 *            the first integer from the input
	 * @param secondInteger
	 *            the second integer from the input
	 * @return the resulting least common multiple
	 */
	public int findLCM(int firstInteger, int secondInteger) {
		if (firstInteger < 1 || secondInteger < 1) {
			ArithmeticException exception = new ArithmeticException("Not valid input");
			throw exception;
		}
		return firstInteger * secondInteger / findGCD(firstInteger, secondInteger);
	}
}