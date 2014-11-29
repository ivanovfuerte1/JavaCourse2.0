package com.sirma.itt.javacourse.collections.pagebean;

/**
 * The class {@link LastPageReached} creates an exception in case the user tries to turn the next
 * page after reaching the last one. It is thrown only when the last page contains all the elements
 * allowed.
 */
public class LastPageReached extends Exception {

	private static final long serialVersionUID = 6029925197241583377L;

	/**
	 * Constructs an exception passing the message to the superclass.
	 * 
	 * @param message
	 *            the message to display
	 * @param cause
	 *            the reason message is displayed
	 */
	protected LastPageReached(String message, Throwable cause) {
		super(message, cause);
	}

}
