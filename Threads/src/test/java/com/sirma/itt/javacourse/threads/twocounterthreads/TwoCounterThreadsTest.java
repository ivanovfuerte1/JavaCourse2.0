package com.sirma.itt.javacourse.threads.twocounterthreads;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The class {@link TwoCounterThreadsTest} contains a test for two counter threads.
 */
public class TwoCounterThreadsTest {

	/**
	 * Test the counter value when two counter threads are started.
	 */
	@Test
	public void test() {
		CounterThreads firstThread = new CounterThreads(5, 10);
		CounterThreads secondThread = new CounterThreads(5, 20);
		secondThread.start();
		firstThread.run();
		assertTrue(firstThread.getCounter() == 10);
		assertTrue(secondThread.getCounter() > 5);
	}
}
