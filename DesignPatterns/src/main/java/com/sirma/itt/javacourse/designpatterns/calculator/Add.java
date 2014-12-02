package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class Add contains method for adding two float values.
 */
public class Add implements Command {

	private Result result = new Result();

	@Override
	public Result execute(float firstOperand, float secondOperand) {
		result.setResult(firstOperand + secondOperand);
		return result;
	}

}
