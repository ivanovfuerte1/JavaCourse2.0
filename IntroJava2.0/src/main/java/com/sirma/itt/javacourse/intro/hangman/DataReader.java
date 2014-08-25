package com.sirma.itt.javacourse.intro.hangman;

/**
 * The interface DataReader contains a method that allows classes to override its method readString
 * in order to have input from different sources.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public interface DataReader {

	/**
	 * Reads string from different input.
	 * 
	 * @return the string from the input
	 */
	String readString();
}
