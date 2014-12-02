package com.sirma.itt.javacourse.designpatterns.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link SingletonTest} contains tests for the methods of the class {@link Singleton}.
 */
public class SingletonTest {

	// Only one of the tests creates an instance because they test a singleton.
	/**
	 * Test the number of instances created calling the method getSingleInstance once.
	 */
	@Test
	public void testOneInstanceCreated() {
		Singleton uniqueInstance = Singleton.getSingleInstance();
		int result = uniqueInstance.numberOfInstances();
		int expected = 1;
		assertEquals(expected, result);
	}

	/**
	 * Test the instances created calling the method getSingleInstance twice for being equal.
	 */
	@Test
	public void testTwoInstancesCreated() {
		Singleton uniqueInstance = Singleton.getSingleInstance();
		Singleton secondInstance = Singleton.getSingleInstance();
		assertEquals(uniqueInstance, secondInstance);
	}

	/**
	 * Test the number of instances created calling the method getSingleInstance twice.
	 */
	@Test
	public void testTwoInstancesCreated2() {
		@SuppressWarnings("unused")
		Singleton uniqueInstance = Singleton.getSingleInstance();
		Singleton secondInstance = Singleton.getSingleInstance();
		int result = secondInstance.numberOfInstances();
		int expected = 1;
		assertEquals(expected, result);
	}

}
