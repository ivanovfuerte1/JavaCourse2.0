package com.sirma.itt.javacourse.networking.calculatorgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class {@link CalculatorController} contains method for assigning actions performed when
 * clicking at buttons on the window of the calculator.
 */
public class CalculatorController implements ActionListener {
	private CalculatorView theView;
	private CalculatorModel theModel;

	/**
	 * Constructs an object of {@link CalculatorController} assigning user interface and logic to
	 * it.
	 * 
	 * @param theView
	 *            the window of the calculator
	 * @param theModel
	 *            the model of the calculator
	 */
	public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		this.theView.addCalculateListener(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (!"=".equals(button) && !"C".equals(button) && !"R".equals(button)) {
			theView.setExpression(theView.getExpression() + button);
		} else if ("=".equals(button)) {
			theView.setExpression(theModel.getSolution(theView.getExpression()));
		} else if ("C".equals(button)) {
			theView.setExpression("");
		} else if ("R".equals(button) && theView.getExpression().length() > 0) {
			theView.setExpression(theView.getExpression().substring(0,
					theView.getExpression().length() - 1));
		}

	}
}
