package com.sirma.itt.javacourse.intro.hangman;

/**
 * This class contains a method that overrides the DataReader method readUserInput, assigning to its
 * default object the data set in its constructor.
 * 
 * @author Svetlosar Kovatchev
 * @version 3.0
 */
public class TestHangmanInput implements DataReader {

	private String[] inputs;

	private int index = 0;

	/**
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
