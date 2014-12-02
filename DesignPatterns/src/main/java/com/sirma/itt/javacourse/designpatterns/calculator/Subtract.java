package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class {@link Subtract} contains a method for getting the result of the subtraction of two
 * float values.
 */
public class Subtract implements Command {

	private Result result = new Result();

	@Override
	public Result execute(float firstOperand, float secondOperand) {
		result.setResult(firstOperand - secondOperand);
		return result;
	}

}
