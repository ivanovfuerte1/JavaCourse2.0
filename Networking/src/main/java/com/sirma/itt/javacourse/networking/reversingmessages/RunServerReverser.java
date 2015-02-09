package com.sirma.itt.javacourse.networking.reversingmessages;

import java.awt.EventQueue;

/**
 * The class {@link RunServerReverser} contains a method for running a Server for reversing
 * messages.
 */
public final class RunServerReverser {

	/**
	 * Runs a server for reversing messages.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ServerReverser().setVisible(true);
			}
		});
	}
}
