package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The interface {@link Command} contains method for executing a command according to the
 * implementing class.
 */
public abstract class Command {
	private Result result = new Result();

	/**
	 * Executes a command with two operands according to the implementing class.
	 * 
	 * @param firstOperand
	 *            the first operand
	 * @param secondOperand
	 *            the second operand
	 * @return the result of the operation
	 */
	abstract Result execute(float firstOperand, float secondOperand);

	/**
	 * @return a
	 */
	public Result getResult() {
		return result;
	}

}
