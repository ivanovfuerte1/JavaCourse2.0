package com.sirma.itt.javacourse.exceptions.listofelements;

/**
 * The class EmptyListException creates an exception in case of trying to remove an element out of
 * an empty list.
 * 
 * @author Svetlosar Kovatchev
 */
public final class EmptyListException extends Exception {
	/**
	 * Generated serialVersionUID.
	 */
	private static final long serialVersionUID = 4621927261374077585L;

	/**
	 * Constructs an exception passing the message to the superclass.
	 * 
	 * @param message
	 *            the message to display
	 * @param cause
	 *            the reason message is displayed
	 */
	protected EmptyListException(String message, Throwable cause) {
		super(message, cause);
	}
}
