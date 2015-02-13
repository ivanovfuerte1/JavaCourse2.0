package com.sirma.itt.javacourse.common;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

/**
 */
public class MementoTest {
	private MementoKeyListener mementoKeyListener;
	private JTextField outputTextField;
	private CareTaker careTaker;
	private Originator originator;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		outputTextField = new JTextField();
		careTaker = new CareTaker();
		originator = new Originator();
		mementoKeyListener = new MementoKeyListener(careTaker, 0, originator, outputTextField);
	}

	/**
	 * 
	 */
	@Test
	public void setStateOfTextFieldTest() {
		originator.setState("abc");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("def");
		careTaker.add(originator.saveStateToMemento());
		mementoKeyListener
				.keyPressed(new KeyEvent(outputTextField, 0, 0, 0, KeyEvent.VK_DOWN, 'a'));
		assertEquals("def", outputTextField.getText());
		mementoKeyListener
				.keyPressed(new KeyEvent(outputTextField, 0, 0, 0, KeyEvent.VK_DOWN, 'a'));
		assertEquals("def", outputTextField.getText());
	}

	/**
	 * 
	 */
	@Test
	public void secondSetStateOfTextFieldTest() {
		originator.setState("abc");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("def");
		careTaker.add(originator.saveStateToMemento());
		mementoKeyListener.keyPressed(new KeyEvent(outputTextField, 0, 0, 0, KeyEvent.VK_UP, 'a'));
		assertEquals("", outputTextField.getText());
		mementoKeyListener
				.keyPressed(new KeyEvent(outputTextField, 0, 0, 0, KeyEvent.VK_DOWN, 'a'));
		mementoKeyListener.keyPressed(new KeyEvent(outputTextField, 0, 0, 0, KeyEvent.VK_UP, 'a'));
		assertEquals("abc", outputTextField.getText());

	}
}
