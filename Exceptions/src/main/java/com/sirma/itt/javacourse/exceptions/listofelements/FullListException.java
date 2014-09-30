package com.sirma.itt.javacourse.exceptions.listofelements;

/**
 * The class FullListException creates an exception in case of trying to add a new element to a full
 * list.
 * 
 * @author Svetlosar Kovatchev
 */
public class FullListException extends Exception {

	/**
	 * Generated serialVersionUID.
	 */
	private static final long serialVersionUID = -2422728091210792578L;

	/**
	 * Constructs an exception passing the message to the superclass.
	 * 
	 * @param message
	 *            the message to display
	 */
	protected FullListException(String message) {
		super(message);
	}
}
