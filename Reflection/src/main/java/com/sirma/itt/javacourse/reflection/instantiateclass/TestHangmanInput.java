package com.sirma.itt.javacourse.reflection.instantiateclass;

/**
 * This class contains a method that overrides the DataReader method readUserInput, assigning to its
 * default object the data set in its constructor.
 * 
 * @author Svetlosar Kovatchev
 */
public class TestHangmanInput implements DataReader {

	private String[] inputs;

	private int index = 0;

	/**
	 * Assigns the input to the default object.
	 * 
	 * @param inputs
	 *            an array of user inputs
	 */
	public TestHangmanInput(String[] inputs) {
		this.inputs = inputs;
	}

	@Override
	public String readUserInput() {
		final String userInput = inputs[index];
		index++;
		return userInput;
	}

}
