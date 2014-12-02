package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class Exponentiate contains method for calculating the result of exponentiating a float
 * number to a float power.
 */
public class Exponentiate implements Command {

	private Result result = new Result();

	@Override
	public Result execute(float firstOperand, float secondOperand) {
		result.setResult((float) Math.pow((double) firstOperand, (double) secondOperand));
		return result;
	}

}
