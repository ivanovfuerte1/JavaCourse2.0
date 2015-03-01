package com.sirma.itt.javacourse.common;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * The class {@link MementoKeyListener} contains methods for undo and redo when arrow keys are
 * pressed.
 */
public class MementoKeyListener implements KeyListener {

	private CareTaker careTaker;
	private int counter = 0;
	private Originator originator;
	private JTextField inputTextField;

	/**
	 * Construct an object of the class {@link MementoKeyListener} assigning values to its
	 * variables.
	 * 
	 * @param careTaker
	 *            the object for adding and returning container classes to its list of classes
	 * @param originator
	 *            the object for saving its variable in container class and assigning the value of a
	 *            container class
	 * @param inputTextField
	 *            the input field
	 */
	public MementoKeyListener(CareTaker careTaker, Originator originator, JTextField inputTextField) {
		this.careTaker = careTaker;
		this.originator = originator;
		this.inputTextField = inputTextField;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN && counter < careTaker.getMementoList().size()) {
			setNewValue();
			counter++;
		} else if (e.getKeyCode() == KeyEvent.VK_UP && counter >= 0) {
			if (counter != 0) {
				counter--;
			}
			setNewValue();
		}
	}

	/**
	 * Sets a new value to the text field depending on the key pressed.
	 */
	private void setNewValue() {
		originator.getStateFromMemento(careTaker.get(counter));
		inputTextField.setText(originator.getState());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

}
