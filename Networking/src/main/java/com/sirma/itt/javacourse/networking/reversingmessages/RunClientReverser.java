package com.sirma.itt.javacourse.networking.reversingmessages;

import java.awt.EventQueue;

/**
 * The class {@link RunClientReverser} contains a method for running a client for reversing
 * messages.
 */
public final class RunClientReverser {
	/**
	 * Default constructor.
	 */
	private RunClientReverser() {
	}

	/**
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ClientReverser().setVisible(true);
			}
		});
	}
}
