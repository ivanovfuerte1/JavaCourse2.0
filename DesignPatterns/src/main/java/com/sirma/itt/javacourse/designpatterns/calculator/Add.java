package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class Add contains method for adding two float values.
 */
public class Add extends Command {

	@Override
	public Result execute(float firstOperand, float secondOperand) {
		getResult().setResult(firstOperand + secondOperand);
		return getResult();
	}

}
