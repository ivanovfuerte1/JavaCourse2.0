package com.sirma.itt.javacourse.networking.transmitter;

import java.awt.EventQueue;

/**
 * The class {@link RunTransmitter} starts a transmitter for sending messages.
 */
public final class RunTransmitter {
	/**
	 * Default constructor.
	 */
	private RunTransmitter() {
	}

	/**
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Transmitter().setVisible(true);
			}
		});
	}
}
