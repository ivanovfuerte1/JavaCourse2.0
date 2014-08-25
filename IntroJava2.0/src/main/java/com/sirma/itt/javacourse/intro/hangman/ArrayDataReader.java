package com.sirma.itt.javacourse.intro.hangman;

/**
 * The class ArrayDataReader contains a method for taking data from an array. NOT YET IMPLEMENTED.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class ArrayDataReader implements DataReader {

	private String[] input;

	private int index;

	/**
	 * Assigns the data from the input array to the default object.
	 * 
	 * @param input
	 *            the input array
	 */
	public ArrayDataReader(String[] input) {
		this.input = input;
		index = -1;
	}

	@Override
	public String readString() {
		index++;
		return input[index];
	}

}
