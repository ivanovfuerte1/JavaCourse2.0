package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class {@link Divide} contains a method for getting the result of the division of two float
 * values.
 */
public class Divide implements Command {

	private Result result = new Result();

	@Override
	public Result execute(float firstOperand, float secondOperand) {
		result.setResult(firstOperand / secondOperand);
		return result;
	}

}
