package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class {@link Divide} contains a method for getting the result of the division of two float
 * values.
 */
public class Divide extends Command {

	@Override
	public Result execute(float firstOperand, float secondOperand) {
		getResult().setResult(firstOperand / secondOperand);
		return getResult();
	}

}
