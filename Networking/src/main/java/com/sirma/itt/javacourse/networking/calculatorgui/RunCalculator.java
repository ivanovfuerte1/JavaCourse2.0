package com.sirma.itt.javacourse.networking.calculatorgui;

/**
 * The class {@link RunCalculator} contains a method for running a calculator for expressions.
 */
public class RunCalculator {
	/**
	 * Runs a calculator for expressions.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {

		CalculatorView theView = new CalculatorView();
		CalculatorModel theModel = new CalculatorModel();
		@SuppressWarnings("unused")
		CalculatorController theControler = new CalculatorController(theView, theModel);
		theView.setVisible(true);
	}
}
