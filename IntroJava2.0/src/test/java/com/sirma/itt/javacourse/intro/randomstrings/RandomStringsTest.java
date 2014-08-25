package com.sirma.itt.javacourse.intro.randomstrings;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This class tests the method generateString of the class RandomStrings.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class RandomStringsTest {

	/**
	 * Tests the method randomString with length of two characters.
	 */
	@Test
	public void test1() {
		String result = new RandomStrings().generateString(2);
		String pattern = "[A-Za-z0-9]{2}";
		assertTrue(result.matches(pattern));
	}

	/**
	 * Tests the method randomString with length of five thousand characters.
	 */
	@Test
	public void test2() {
		String result = new RandomStrings().generateString(150);
		String pattern = "[A-Za-z0-9]{150}";
		assertTrue(result.matches(pattern));
	}

	/**
	 * Tests the method randomString with length of zero characters.
	 */
	@Test
	public void test3() {
		String result = new RandomStrings().generateString(0);
		String pattern = "[A-Za-z0-9]{0}";
		assertTrue(result.matches(pattern));
	}

}
