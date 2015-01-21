package com.sirma.itt.javacourse.chat.server;

/**
 * The class {@link RunChatServer} contains a method for running a server for interchanging messages
 * among clients.
 */
public final class RunChatServer {

	/**
	 * Runs a server for interchanging messages among clients.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		/*
		 * SwingUtilities.invokeLater(new Runnable() { public void run() {
		 */
		new ChatServerFrame().setVisible(true);
		/*
		 * } });
		 */
	}
}
