package com.sirma.itt.javacourse.chat.client;

import javax.swing.SwingUtilities;

/**
 * The class {@link RunChatClient} contains a method for running a client for reversing messages.
 */
public final class RunChatClient {

	/**
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ClientConnectorFrame().setVisible(true);
			}
		});
	}
}
