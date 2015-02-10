package com.sirma.itt.javacourse.networking.transmitter;


/**
 * The class {@link RunClient} contains a method for running a client that receives messages from
 * transmitter.
 */
public final class RunClient {

	/**
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		new Client().setVisible(true);
	}
}
