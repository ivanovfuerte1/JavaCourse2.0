package com.sirma.itt.javacourse.designpatterns.objectpool;

/**
 * The class {@link NoAvailableResource} contains a method for creating an exception when no
 * resources are available.
 */
public class NoAvailableResource extends Exception {

	private static final long serialVersionUID = 3350825756334550302L;

	/**
	 * Constructs an exception passing the message to the superclass.
	 * 
	 * @param message
	 *            the message to display
	 * @param cause
	 *            the reason message is displayed
	 */
	protected NoAvailableResource(String message, Throwable cause) {
		super(message, cause);
	}

}
