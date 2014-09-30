package com.sirma.itt.javacourse.exceptions.readnumbers;

/**
 * The class OutOfRangeException constructs a new exception in case of input out of a specified
 * range.
 * 
 * @author Svetlosar Kovatchev
 */
public final class OutOfRangeException extends Exception {

	/**
	 * Generated serialVersionUID.
	 */
	private static final long serialVersionUID = -252845588594085079L;

	/**
	 * Constructs an exception passing the message to the superclass.
	 * 
	 * @param message
	 *            the message to display
	 */
	protected OutOfRangeException(String message) {
		super(message);
	}
}
