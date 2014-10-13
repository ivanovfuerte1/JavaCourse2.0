package com.sirma.itt.javacourse.reflection.instantiateclass;

/**
 * The interface DataReader contains a method that allows classes to override its method readString
 * in order to have input from different sources.
 * 
 * @author Svetlosar Kovatchev
 */
public interface DataReader {

	/**
	 * Reads string from different input.
	 * 
	 * @return the string from the input
	 */
	String readUserInput();
}
