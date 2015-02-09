package com.sirma.itt.javacourse.networking.clientinfo;

/**
 * The class {@link RunServer} runs a server for receiving messages from and sending to clients.
 */
public final class RunServer {

	/**
	 * Runs a server for receiving messages from and sending to clients.
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		new ServerFrame().setVisible(true);
	}
}
