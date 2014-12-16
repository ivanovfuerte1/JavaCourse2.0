package com.sirma.itt.javacourse.designpatterns.proxy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link ProxyTest} contains tests for the methods of the methods of the class
 * {@link IntegerFactory}.
 */
public class ProxyTest {

	/**
	 * Tests the method getTestValue of the class {@link IntegerFactory} after creating an instance.
	 */
	@Test
	public void testAfter() {
		int actual = new IntegerFactory().createInstance().getInteger();
		int expected = 6;
		assertEquals(expected, actual);
	}

}
