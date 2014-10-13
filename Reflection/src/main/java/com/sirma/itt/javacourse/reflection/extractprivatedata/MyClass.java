package com.sirma.itt.javacourse.reflection.extractprivatedata;

/**
 * The class MyClass contains a method for printing a string from the input and another one for
 * finding the Greatest common divisor.
 * 
 * @author Svetlosar Kovatchev
 */
public class MyClass {

	private int numberRepetitions = 2;
	private int firstInteger = 15;

	private int secondInteger = 25;

	/**
	 * Prints the string from the input.
	 *
	 * @param input
	 *            a string from the input
	 */
	@SuppressWarnings("unused")
	private void print(String input) {
		for (int i = 0; i < numberRepetitions; i++) {
			System.out.println(input);
		}
	}

	/**
	 * Finds the greatest common divisor of two integers.
	 * 
	 * @return the resulting greatest common divisor
	 */

	@SuppressWarnings("unused")
	private int findGCD() {
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
}