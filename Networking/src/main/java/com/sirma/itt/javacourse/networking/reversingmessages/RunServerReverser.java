package com.sirma.itt.javacourse.networking.reversingmessages;


/**
 * The class {@link RunServerReverser} contains a method for running a Server for reversing
 * messages.
 */
public final class RunServerReverser {

	/**
	 * Runs a server for reversing messages.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		new ServerReverser().setVisible(true);
	}
}
