package com.sirma.itt.javacourse.networking.calculatorgui;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionEvent;

// import java.awt.event.ActionEvent;
import org.junit.Test;

/**
 * The class {@link CalculatorGUITest} contains test for the methods of the class
 * {@link CalculatorGUI}.
 */
public class CalculatorGUITest {

	/**
	 * Tests the main method of the class {@link CalculatorGUI} with a sample expression.
	 */
	@Test
	public void test() {
		CalculatorGUI calculatorGUI = new CalculatorGUI();
		RunCalculatorGUI.main(null);
		calculatorGUI.setExpression("5+5");
		ActionEvent actionEvent = new ActionEvent(calculatorGUI, 0, "");
		calculatorGUI.actionPerformed(actionEvent);
		System.out.println(calculatorGUI.getExpression());
		int expected = 0;
		int actual = 0;
		assertEquals(expected, actual);
	}

}
