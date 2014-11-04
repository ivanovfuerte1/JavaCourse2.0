package com.sirma.itt.javacourse.libraries.randomstrings;

/**
 * The class {@link RandomStringsPacked} contains main method for testing the methods of
 * {@link RandomStrings}.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public final class RandomStringsPacked {
	/**
	 * Default constructor.
	 */
	private RandomStringsPacked() {
	}

	/**
	 * Tests the method generateString from a jar file.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		System.out.println(RandomStrings.generateString(10));
	}

}
