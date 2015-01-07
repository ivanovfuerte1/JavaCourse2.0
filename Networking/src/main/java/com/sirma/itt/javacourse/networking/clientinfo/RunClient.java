package com.sirma.itt.javacourse.networking.clientinfo;

import java.awt.EventQueue;

/**
 * The class {@link RunClient} contains a method for running a client for for receiving information
 * and displaying it.
 */
public final class RunClient {
	/**
	 * Default constructor.
	 */
	private RunClient() {
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Client().setVisible(true);
			}
		});
	}
}
