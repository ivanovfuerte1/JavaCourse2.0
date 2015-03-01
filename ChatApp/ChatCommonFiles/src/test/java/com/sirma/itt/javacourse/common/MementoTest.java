package com.sirma.itt.javacourse.common;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

/**
 * The class {@link MementoTest} contains tests for the methods of the class
 * {@link MementoKeyListener}.
 */
public class MementoTest {
	private MementoKeyListener mementoKeyListener;
	private JTextField inputTextField;
	private CareTaker careTaker;
	private Originator originator;

	/**
	 * Sets a {@link MementoKeyListener} with sample parameters.
	 */
	@Before
	public void setUp() {
		inputTextField = new JTextField();
		careTaker = new CareTaker();
		originator = new Originator();
		mementoKeyListener = new MementoKeyListener(careTaker, originator, inputTextField);
	}

	/**
	 * Tests the content of the input text field after key down is pressed two times.
	 */
	@Test
	public void setStateOfTextFieldTest() {
		originator.setState("abc");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("def");
		careTaker.add(originator.saveStateToMemento());
		mementoKeyListener.keyPressed(new KeyEvent(inputTextField, 0, 0, 0, KeyEvent.VK_DOWN, 'a'));
		assertEquals("abc", inputTextField.getText());
		mementoKeyListener.keyPressed(new KeyEvent(inputTextField, 0, 0, 0, KeyEvent.VK_DOWN, 'a'));
		assertEquals("def", inputTextField.getText());
	}

	/**
	 * Tests the content of the input text field after key down and up are pressed several times.
	 */
	@Test
	public void secondSetStateOfTextFieldTest() {
		originator.setState("abc");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("def");
		careTaker.add(originator.saveStateToMemento());
		mementoKeyListener.keyPressed(new KeyEvent(inputTextField, 0, 0, 0, KeyEvent.VK_UP, 'a'));
		assertEquals("abc", inputTextField.getText());
		mementoKeyListener.keyPressed(new KeyEvent(inputTextField, 0, 0, 0, KeyEvent.VK_DOWN, 'a'));
		mementoKeyListener.keyPressed(new KeyEvent(inputTextField, 0, 0, 0, KeyEvent.VK_UP, 'a'));
		assertEquals("abc", inputTextField.getText());

	}
}
