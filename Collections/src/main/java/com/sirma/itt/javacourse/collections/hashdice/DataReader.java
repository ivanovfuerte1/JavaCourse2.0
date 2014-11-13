package com.sirma.itt.javacourse.collections.hashdice;

/**
 * The interface {@link DataReader} contains a method that allows classes to override its method
 * getCombination in order to have input from different sources.
 * 
 * @author Svetlosar Kovatchev
 */
public interface DataReader {
	/**
	 * Reads a combination or several combinations of two dice with given number of sides thrown.
	 * 
	 * @param m
	 *            the number of sides of the die to throw
	 * @return a string containing a combination or several combinations of two dice thrown
	 */
	String getCombination(int m);
}
