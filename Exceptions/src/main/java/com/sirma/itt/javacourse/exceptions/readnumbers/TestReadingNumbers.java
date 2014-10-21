package com.sirma.itt.javacourse.exceptions.readnumbers;

/**
 * The class TestReadingNumbers contains a method that overrides the DataReader method
 * readUserInput, assigning to its default object the data set in its constructor.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class TestReadingNumbers implements DataReader {
	private String[] inputs;
	private int index = 0;

	/**
	 * @param inputs
	 *            an array of user inputs
	 */
	public TestReadingNumbers(String[] inputs) {
		this.inputs = inputs;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String readUserInput() {
		String userInput;
		try {
			userInput = inputs[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			return e.toString();
		} catch (NullPointerException e) {
			return e.toString();
		}
		index++;
		return userInput;
	}

}
