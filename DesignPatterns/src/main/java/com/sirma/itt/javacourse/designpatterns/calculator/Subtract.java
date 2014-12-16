package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class {@link Subtract} contains a method for getting the result of the subtraction of two
 * float values.
 */
public class Subtract extends Command {

	@Override
	public Result execute(float firstOperand, float secondOperand) {
		getResult().setResult(firstOperand - secondOperand);
		return getResult();
	}

}
