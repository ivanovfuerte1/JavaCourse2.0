package com.sirma.itt.javacourse.networking.calculatorgui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * The class {@link CalculatorControllerTest} contains test for calling methods by Mockito.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculatorControllerTest {

	@Mock
	private CalculatorView calculatorView;
	@Mock
	private CalculatorModel calculatorModel;
	private CalculatorController calculatorController;

	/**
	 * Sets the calculatorController with mocked arguments.
	 */
	@Before
	public void setUp() {
		calculatorController = new CalculatorController(calculatorView, calculatorModel);
	}

	/**
	 * Tests calling methods by Mockito.
	 */
	@Test
	public void test() {
		calculatorController.actionPerformed(new ActionEvent(new JButton(), 0, "="));
		Mockito.verify(calculatorView, Mockito.atLeast(1)).setExpression(Mockito.anyString());
		Mockito.verify(calculatorView, Mockito.atLeast(1)).getExpression();
		Mockito.verify(calculatorModel, Mockito.atLeast(1)).getSolution(Mockito.anyString());
	}

}
