package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class {@link Multiply} contains a method for calculating the result of the multiplication of
 * two float values.
 */
public class Multiply implements Command {

	private Result result = new Result();

	@Override
	public Result execute(float firstOperand, float secondOperand) {
		result.setResult(firstOperand * secondOperand);
		return result;
	}

}
