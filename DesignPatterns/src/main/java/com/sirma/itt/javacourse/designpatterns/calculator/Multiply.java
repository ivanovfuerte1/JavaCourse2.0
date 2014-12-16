package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class {@link Multiply} contains a method for calculating the result of the multiplication of
 * two float values.
 */
public class Multiply extends Command {

	@Override
	public Result execute(float firstOperand, float secondOperand) {
		getResult().setResult(firstOperand * secondOperand);
		return getResult();
	}

}
