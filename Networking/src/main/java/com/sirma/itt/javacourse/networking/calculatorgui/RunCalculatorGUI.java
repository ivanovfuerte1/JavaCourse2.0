package com.sirma.itt.javacourse.networking.calculatorgui;

import java.awt.EventQueue;

/**
 * The class {@link RunCalculatorGUI} contains a method for launching the CalculatorGUI.
 */
public final class RunCalculatorGUI {
	/**
	 * Default constructor.
	 */
	private RunCalculatorGUI() {
	}

	/**
	 * Launches the CalculatorGUI.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CalculatorGUI frame = new CalculatorGUI();
				frame.setVisible(true);
			}
		});
	}
}
