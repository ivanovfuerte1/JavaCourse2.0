package com.sirma.itt.javacourse.networking.calculatorgui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 */
public class CalculatorModelTest {
	private CalculatorModel calculatorModel = new CalculatorModel();

	/**
	 * Tests the method getSolution of the class {@link CalculatorModel} with sample values.
	 */
	@Test
	public void calculateSum() {
		String actual = calculatorModel.getSolution("2+3");
		String expected = "5.0";
		assertEquals(expected, actual);
	}

	/**
	 * Tests the method getSolution of the class {@link CalculatorModel} with a complex expression.
	 */
	@Test
	public void calculateExpression() {
		String actual = calculatorModel.getSolution("2+3*10");
		String expected = "32.0";
		assertEquals(expected, actual);
	}

}
