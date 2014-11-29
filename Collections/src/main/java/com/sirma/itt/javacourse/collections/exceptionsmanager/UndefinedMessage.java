package com.sirma.itt.javacourse.collections.exceptionsmanager;

/**
 * The class {@link UndefinedMessage} creates an error when the message is not defined.
 */
public class UndefinedMessage extends Exception {

	/**
	 * Generated serialVersionUID.
	 */
	private static final long serialVersionUID = 7274267601022846523L;

	/**
	 * Constructs an exception passing the message to the superclass.
	 * 
	 * @param message
	 *            the message to display
	 * @param cause
	 *            the reason message is displayed
	 */
	protected UndefinedMessage(String message, Throwable cause) {
		super(message, cause);
	}

}
