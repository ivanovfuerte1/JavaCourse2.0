package com.sirma.itt.javacourse.networking.calculatorgui;

import com.sirma.itt.javacourse.designpatterns.calculator.Calculator;

/**
 * The class {@link CalculatorModel} contains a method for getting the solution of the expression
 * set as a parameter.
 */
public class CalculatorModel {
	private Calculator calculator = new Calculator();

	/**
	 * @param input
	 *            the input value
	 * @return the result of the calculation
	 */
	public String getSolution(String input) {
		return calculator.getResult(input);
	}

}
