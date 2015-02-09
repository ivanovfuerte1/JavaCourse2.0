package com.sirma.itt.javacourse.networking.clientserverconversation;

/**
 * The class {@link RunClient} contains method for running an user interface that can display the
 * date.
 */
public final class RunClient {

	/**
	 * Runs an user interface that can display the date.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		new ClientDateDisplay().setVisible(true);
	}
}
