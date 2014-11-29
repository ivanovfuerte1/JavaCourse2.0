package com.sirma.itt.javacourse.collections.pagebean;

/**
 * The class {@link FirstPageReached} creates an exception when the user tries to turn the previous
 * page after reaching the first one.
 */
public class FirstPageReached extends Exception {

	private static final long serialVersionUID = -3271816732965489013L;

	/**
	 * Constructs an exception passing the message to the superclass.
	 * 
	 * @param message
	 *            the message to display
	 * @param cause
	 *            the reason message is displayed
	 */
	protected FirstPageReached(String message, Throwable cause) {
		super(message, cause);
	}

}
