package com.sirma.itt.javacourse.collections.hashdice;

/**
 * The class {@link TestReader} contains a method for reading a combination or a set of combinations
 * of two dice thrown by assigning it to its constructor.
 * 
 * @author Svetlosar Kovatchev
 */
public class TestReader implements DataReader {
	private String[] input;
	private int index = 0;

	/**
	 * Constructs an object containing a combination or a set of combinations of two dice thrown by
	 * passing it to its constructor.
	 * 
	 * @param input
	 *            a string containing a combination or a set of combinations of two dice thrown
	 */
	public TestReader(String[] input) {
		this.input = input;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCombination(int m) {
		final String userInput = input[index];
		index++;
		return userInput;
	}

}
