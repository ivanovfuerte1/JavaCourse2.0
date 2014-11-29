package com.sirma.itt.javacourse.collections.hashdice;

import java.util.Random;

/**
 * The class {@link RandomData} contains a method for generating a random combination of integers
 * representing the result of two dice thrown.
 * 
 * @author Svetlosar Kovatchev
 */
public class RandomData implements DataReader {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCombination(int numberOfSides) {
		Random random = new Random();
		int firstDie = random.nextInt(numberOfSides) + 1;
		int secondDie = random.nextInt(numberOfSides) + 1;
		return new StringBuilder().append(firstDie).append(",").append(secondDie).toString();
	}
}