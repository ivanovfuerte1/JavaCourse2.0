package com.sirma.itt.javacourse.client;

/**
 * The class {@link RunChatClient} contains a method for running the client side of a chat
 * application.
 */
public final class RunChatClient {

	/**
	 * Runs the client side of a chat application.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		new ClientConnectionFrame().setVisible(true);
	}
}
