package com.sirma.itt.javacourse.designpatterns.calculator;

/**
 * The class {@link Result} contains getter and setter for its static variable.
 */
public class Result {
	private static float result;

	/**
	 * Getter method for result.
	 *
	 * @return the result
	 */
	public float getResult() {
		return result;
	}

	/**
	 * Setter method for result.
	 *
	 * @param result
	 *            the result to set
	 */
	public void setResult(float result) {
		Result.result = result;
	}

}
