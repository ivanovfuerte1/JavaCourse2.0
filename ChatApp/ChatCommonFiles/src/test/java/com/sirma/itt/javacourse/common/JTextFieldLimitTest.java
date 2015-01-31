package com.sirma.itt.javacourse.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link JTextFieldLimitTest} contains tests for the methods of the class
 * {@link JTextFieldLimit}.
 */
public class JTextFieldLimitTest {
	/**
	 * Tests the method getLimit with sample value.
	 */
	@Test
	public void test() {
		int expected = 3;
		JTextFieldLimit jTextFieldLimit = new JTextFieldLimit(3);
		int actual = jTextFieldLimit.getLimit();
		assertEquals(expected, actual);
	}

}
