package com.sirma.itt.javacourse.networking.clientinfo;

import java.awt.EventQueue;

/**
 * The class {@link RunServer} runs a server for receiving messages from and sending to clients.
 */
public final class RunServer {
	/**
	 * Default constructor.
	 */
	private RunServer() {
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Server().setVisible(true);
			}
		});
	}
}
