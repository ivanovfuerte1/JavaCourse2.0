package com.sirma.itt.javacourse.designpatterns.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link Calculator} contains methods for calculating sum, subtraction, multiplication,
 * division and exponentiation of two or more values.
 */
public class Calculator {
	private static final Logger LOGGER = LogManager.getLogger(Calculator.class);

	/**
	 * Separates the input into details and returns the result of the calculus.
	 * 
	 * @param string
	 *            the input
	 * @return the result of the calculus
	 */
	public String getDetails(String string) {
		String[] operands = new String[2];
		
		// XXX: constants!
		if (string.contains("+") && string.length() != 1) {
			int separatorIndex = string.indexOf('+');
			subCalculus(string, operands, separatorIndex);
			return Float.toString(calculate('+', Float.parseFloat(operands[0]),
					Float.parseFloat(operands[1])));
		} else if (string.contains("-") && string.length() != 1) {
			int separatorIndex = string.indexOf('-');
			subCalculus(string, operands, separatorIndex);
			return Float.toString(calculate('-', Float.parseFloat(operands[0]),
					Float.parseFloat(operands[1])));
		} else if (string.contains("*") && string.length() != 1) {
			int separatorIndex = string.indexOf('*');
			subCalculus(string, operands, separatorIndex);
			return Float.toString(calculate('*', Float.parseFloat(operands[0]),
					Float.parseFloat(operands[1])));
		} else if (string.contains("/") && string.length() != 1) {
			int separatorIndex = string.indexOf('/');
			subCalculus(string, operands, separatorIndex);
			return Float.toString(calculate('/', Float.parseFloat(operands[0]),
					Float.parseFloat(operands[1])));
		} else if (string.contains("^") && string.length() != 1) {
			int separatorIndex = string.indexOf('^');
			subCalculus(string, operands, separatorIndex);
			try {
				Integer.parseInt(operands[1]);
			} catch (NumberFormatException e) {
				LOGGER.error("The exponent should be an integer", e);
				throw new NumberFormatException();
			}
			return Float.toString(calculate('^', Float.parseFloat(operands[0]),
					Float.parseFloat(operands[1])));
		}
		return string;
	}

	/**
	 * Checks if some of the parts of the input contains a string to be calculated and assigns the
	 * parts to variables in order to do the final calculation.
	 * 
	 * @param string
	 *            the full input or the current part of it if the method is called recursively
	 * @param operands
	 *            the parts of the string to be calculated
	 * @param separatorIndex
	 *            the index of the operation with maximum priority
	 */
	public void subCalculus(String string, String[] operands, int separatorIndex) {
		String[] parts = new String[2];
		parts[0] = string.substring(0, separatorIndex);
		parts[1] = string.substring(separatorIndex + 1);
		for (int i = 0; i < parts.length; i++) {
			// XXX: Compile pattern
			if (parts[i].matches("(.*)\\+(.*)||(.*)\\-(.*)||(.*)\\*(.*)||(.*)\\/(.*)||(.*)\\^(.*)")) {
				operands[i] = getDetails(parts[i]);
			} else {
				operands[i] = parts[i];
			}
		}
	}

	/**
	 * Calculates the simple operation with two operands.
	 * 
	 * @param operator
	 *            the sign that marks the operation to do
	 * @param firstOperand
	 *            the first operand
	 * @param secondOperand
	 *            the second operand
	 * @return the result of the current calculus
	 */
	public float calculate(char operator, float firstOperand, float secondOperand) {
		Command command = null;
		switch (operator) {
			case '+':
				 command = new Add();
			case '-':
				 command = new Subtract();
			case '*':
				 command = new Multiply();
			case '/':
				 command = new Divide();
			case '^':
				 command = new Exponentiate();
			default:
				// This result is not supposed to be reached ever.
				

		}
		
		return command.execute(firstOperand, secondOperand).getResult();
	}
}
