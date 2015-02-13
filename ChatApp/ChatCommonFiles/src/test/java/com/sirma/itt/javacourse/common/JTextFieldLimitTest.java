package com.sirma.itt.javacourse.common;

import static org.junit.Assert.assertEquals;

import javax.swing.text.BadLocationException;

import org.junit.Before;
import org.junit.Test;

/**
 * The class {@link JTextFieldLimitTest} contains tests for the methods of the class
 * {@link JTextFieldLimit}.
 */
public class JTextFieldLimitTest {
	private JTextFieldLimit jTextFieldLimit;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		jTextFieldLimit = new JTextFieldLimit(5);
	}

	/**
	 * Tests the method getLimit with sample value.
	 */
	@Test
	public void test() {
		int expected = 3;
		jTextFieldLimit = new JTextFieldLimit(3);
		int actual = jTextFieldLimit.getLimit();
		assertEquals(expected, actual);
	}

	/**
	 * Tests the method getLimit with sample value.
	 */
	@Test
	public void test2() {
		try {
			jTextFieldLimit.insertString(0, "abc", null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		assertEquals(3, jTextFieldLimit.getLength());
	}

	/**
	 * Tests the method getLimit with sample value.
	 */
	@Test
	public void test3() {
		try {
			jTextFieldLimit.insertString(0, null, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		assertEquals(0, jTextFieldLimit.getLength());
	}

}
