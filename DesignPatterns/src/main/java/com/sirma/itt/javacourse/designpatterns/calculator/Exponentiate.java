package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class Exponentiate contains method for calculating the result of exponentiating a float
 * number to a float power.
 */
public class Exponentiate extends Command {

	@Override
	public Result execute(float firstOperand, float secondOperand) {
		getResult().setResult((float) Math.pow((double) firstOperand, (double) secondOperand));
		return getResult();
	}

}
