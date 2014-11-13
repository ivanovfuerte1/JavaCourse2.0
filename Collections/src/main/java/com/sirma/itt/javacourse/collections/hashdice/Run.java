package com.sirma.itt.javacourse.collections.hashdice;

/**
 * The class {@link Run} contains a method for testing the methods of the class {@link HashDice} for
 * generating a statistic containing combinations of integers representing the result of two dice
 * thrown and printing it.
 * 
 * @author Svetlosar Kovatchev
 */
public final class Run {
	/**
	 * Default constructor.
	 */
	private Run() {
	}

	/**
	 * Tests the methods of the class {@link HashDice} for generating a statistic containing
	 * combinations of integers representing the result of two dice thrown and printing it.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		HashDice hashDice = new HashDice(3, 20, new RandomData());
		hashDice.printStatistics(hashDice.combinationsCreator());
	}
}
