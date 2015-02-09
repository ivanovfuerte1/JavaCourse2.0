package com.sirma.itt.javacourse.networking.calculatorgui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The class {@link CalculatorView} contains methods for setting the user interface of the
 * calculator.
 */
public class CalculatorView extends JFrame {
	private static final long serialVersionUID = -3676108650093499082L;
	private JPanel contentPane;
	private JTextField resultField = new JTextField();
	private static final String[] BUTTONS = { "7", "8", "9", "/", "C", "4", "5", "6", "*", "R",
			"1", "2", "3", "-", "=", "0", ".", "+" };
	private JButton[] tempBtn = new JButton[BUTTONS.length];

	/**
	 * Initializes the components of the user interface.
	 */
	public CalculatorView() {
		setTitle("CalculatorGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 325);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		resultField.setBounds(10, 30, 290, 40);
		resultField.setHorizontalAlignment(JTextField.RIGHT);
		contentPane.add(resultField);
		resultField.setEditable(false);

		initialize();
	}

	/**
	 * Sets the graphical interface.
	 */
	private void initialize() {
		for (int i = 0; i < BUTTONS.length; i++) {
			tempBtn[i] = new JButton(BUTTONS[i]);
			if (!"0".equals(BUTTONS[i]) && !".".equals(BUTTONS[i]) && !"+".equals(BUTTONS[i])
					&& !"=".equals(BUTTONS[i])) {
				// Order most of the buttons with a single complex expression in
				// a loop
				tempBtn[i].setBounds(10 + i * 60 % 300, 80 + i / 5 * 50, 50, 40);
			} else if ("0".equals(BUTTONS[i])) {
				tempBtn[i].setBounds(10, 230, 110, 40);
			} else if (".".equals(BUTTONS[i])) {
				tempBtn[i].setBounds(130, 230, 50, 40);
			} else if ("+".equals(BUTTONS[i])) {
				tempBtn[i].setBounds(190, 230, 50, 40);
			} else if ("=".equals(BUTTONS[i])) {
				tempBtn[i].setBounds(250, 180, 50, 90);
			}
			contentPane.add(tempBtn[i]);
		}
	}

	/**
	 * Adds an action listener for the action performed when clicking buttons.
	 * 
	 * @param actionListener
	 *            the listener of the current button
	 */
	public void addCalculateListener(ActionListener actionListener) {
		for (JButton button : tempBtn) {
			button.addActionListener(actionListener);
		}
	}

	/**
	 * Returns the text in the text field.
	 * 
	 * @return the text in the text field
	 */
	public String getExpression() {
		return resultField.getText();
	}

	/**
	 * Sets text in the text field.
	 * 
	 * @param expression
	 *            the text to be set in the text field
	 */
	public void setExpression(String expression) {
		resultField.setText(expression);
	}

}
