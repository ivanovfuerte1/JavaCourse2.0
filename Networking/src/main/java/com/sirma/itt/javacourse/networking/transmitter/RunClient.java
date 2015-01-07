package com.sirma.itt.javacourse.networking.transmitter;

import java.awt.EventQueue;

/**
 * The class {@link RunClient} contains a method for running a client that receives messages from
 * transmitter.
 */
public final class RunClient {
	/**
	 * Default constructor.
	 */
	private RunClient() {
	}

	/**
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Client().setVisible(true);
			}
		});
	}
}
