package com.sirma.itt.javacourse.networking.clientserverconversation;

import java.awt.EventQueue;

/**
 * The class {@link RunDateGenerator} contains a method for running a generator for dates.
 */
public final class RunDateGenerator {
	/**
	 * Default constructor.
	 */
	private RunDateGenerator() {
	}

	/**
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DateGenerator().setVisible(true);
			}
		});
	}
}
