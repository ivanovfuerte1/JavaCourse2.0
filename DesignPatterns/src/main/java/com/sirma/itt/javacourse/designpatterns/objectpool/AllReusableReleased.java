package com.sirma.itt.javacourse.designpatterns.objectpool;

/**
 * The class {@link AllReusableReleased} contains a method for creating an exception when all
 * reusable are released.
 */
public class AllReusableReleased extends Exception {

	private static final long serialVersionUID = -5239478738371367467L;

	/**
	 * Constructs an exception passing the message to the superclass.
	 * 
	 * @param message
	 *            the message to display
	 * @param cause
	 *            the reason message is displayed
	 */
	protected AllReusableReleased(String message, Throwable cause) {
		super(message, cause);
	}
}
