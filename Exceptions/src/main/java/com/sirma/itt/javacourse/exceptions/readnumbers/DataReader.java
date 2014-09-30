package com.sirma.itt.javacourse.exceptions.readnumbers;

/**
 * The interface DataReader contains a method that allows classes to override its method readString
 * in order to have input from different sources.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public interface DataReader {
	/**
	 * Reads the string from different input.
	 * 
	 * @return the string from different input
	 */
	String readUserInput();
}
