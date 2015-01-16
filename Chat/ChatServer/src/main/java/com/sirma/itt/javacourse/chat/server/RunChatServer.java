package com.sirma.itt.javacourse.chat.server;


/**
 * The class {@link RunChatServer} contains a method for running a Server for reversing messages.
 */
public final class RunChatServer {

	/**
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
