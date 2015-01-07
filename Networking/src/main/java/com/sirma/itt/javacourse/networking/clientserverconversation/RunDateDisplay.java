package com.sirma.itt.javacourse.networking.clientserverconversation;

/**
 * The class {@link RunDateDisplay} contains methods for running an user interface that can display
 * the date.
 */
public final class RunDateDisplay {
	/**
	 * Default constructor.
	 */
	private RunDateDisplay() {
	}

	/**
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DateDisplay().setVisible(true);
			}
		});
	}
}
