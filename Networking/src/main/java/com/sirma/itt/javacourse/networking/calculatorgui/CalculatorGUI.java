package com.sirma.itt.javacourse.networking.calculatorgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.designpatterns.calculator.Calculator;

/**
 * The class {@link CalculatorGUI} creates a calculator.
 */
public class CalculatorGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -8734956488678969786L;
	private JPanel contentPane;
	private JTextField resultField = new JTextField();
	private static final String[] BUTTONS = { "7", "8", "9", "/", "C", "4", "5", "6", "*", "R",
			"1", "2", "3", "-", "=", "0", ".", "+" };
	private Calculator calculator = new Calculator();

	/**
	 * Initializes the components of the user interface.
	 */
	public CalculatorGUI() {
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
	 * Initializes the graphical interface.
	 */
	private void initialize() {
		for (int i = 0; i < BUTTONS.length; i++) {
			JButton tempBtn = new JButton(BUTTONS[i]);
			tempBtn.addActionListener(this);
			if (!"0".equals(BUTTONS[i]) && !".".equals(BUTTONS[i]) && !"+".equals(BUTTONS[i])
					&& !"=".equals(BUTTONS[i])) {
				// Order most of the buttons with a single complex expression in a loop
				tempBtn.setBounds(10 + i * 60 % 300, 80 + i / 5 * 50, 50, 40);
			} else if ("0".equals(BUTTONS[i])) {
				tempBtn.setBounds(10, 230, 110, 40);
			} else if (".".equals(BUTTONS[i])) {
				tempBtn.setBounds(130, 230, 50, 40);
			} else if ("+".equals(BUTTONS[i])) {
				tempBtn.setBounds(190, 230, 50, 40);
			} else if ("=".equals(BUTTONS[i])) {
				tempBtn.setBounds(250, 180, 50, 90);
			}
			contentPane.add(tempBtn);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (!"=".equals(button) && !"C".equals(button) && !"R".equals(button)) {
			resultField.setText(resultField.getText() + button);
		} else if ("=".equals(button)) {
			resultField.setText(calculator.getDetails(resultField.getText()));
		} else if ("C".equals(button)) {
			resultField.setText("");
		} else if ("R".equals(button) && resultField.getText().length() > 0) {
			resultField.setText(resultField.getText().substring(0,
					resultField.getText().length() - 1));
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
