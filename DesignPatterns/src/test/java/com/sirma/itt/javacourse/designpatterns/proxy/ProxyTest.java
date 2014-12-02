package com.sirma.itt.javacourse.designpatterns.proxy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link ProxyTest} contains tests for the methods of the methods of the class
 * {@link IntegerFactory}.
 */
public class ProxyTest {

	/**
	 * Tests the method getTestValue of the class {@link IntegerFactory} before creating an
	 * instance.
	 */
	@Test
	public void testBefore() {
		IntegerFactory integerFactory = new IntegerFactory();
		int expected = 0;
		int actual = integerFactory.getTestValue();
		assertEquals(expected, actual);
	}

	/**
	 * Tests the method getTestValue of the class {@link IntegerFactory} after creating an instance.
	 */
	@Test
	public void testAfter() {
		IntegerFactory integerFactory = new IntegerFactory();
		integerFactory.createInstance();
		int expected = 6;
		int actual = integerFactory.getTestValue();
		assertEquals(expected, actual);
	}

}
