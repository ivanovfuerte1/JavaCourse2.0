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
	private int counter;
	private Originator originator;
	private JTextField outputTextField;

	/**
	 * Construct an object of the class {@link MementoKeyListener} assigning values to its
	 * variables.
	 * 
	 * @param careTaker
	 *            the object for adding and returning container classes to its list of classes
	 * @param counter
	 *            counts the number of states of memento
	 * @param originator
	 *            the object for saving its variable in container class and assigning the value of a
	 *            container class
	 * @param outputTextField
	 *            the text in the output field
	 */
	public MementoKeyListener(CareTaker careTaker, int counter, Originator originator,
			JTextField outputTextField) {
		this.careTaker = careTaker;
		this.counter = counter;
		this.originator = originator;
		this.outputTextField = outputTextField;
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
		if (e.getKeyCode() == KeyEvent.VK_DOWN && counter < careTaker.getMementoList().size() - 1) {
			originator.getStateFromMemento(careTaker.get(++counter));
			String result = originator.getState();
			outputTextField.setText(ConstantsChat.EMPTY_STRING);
			outputTextField.setText(result);
		} else if (e.getKeyCode() == KeyEvent.VK_UP && counter > 0) {
			originator.getStateFromMemento(careTaker.get(--counter));
			String result = originator.getState();
			outputTextField.setText(ConstantsChat.EMPTY_STRING);
			outputTextField.setText(result);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

}
