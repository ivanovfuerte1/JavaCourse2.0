package com.sirma.itt.javacourse.collections.hashdice;

import java.util.Random;

/**
 * The class {@link RandomData} contains a method for generating a random combination of integers
 * representing the result of two dice thrown.
 * 
 * @author Svetlosar Kovatchev
 */
public class RandomData implements DataReader {
	private StringBuilder combination = new StringBuilder();
	private Random random = new Random();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCombination(int m) {
		combination.setLength(0);
		int firstDie = random.nextInt(m) + 1;
		int secondDie = random.nextInt(m) + 1;
		combination.append(firstDie);
		combination.append(",");
		combination.append(secondDie);
		return combination.toString();
	}
}