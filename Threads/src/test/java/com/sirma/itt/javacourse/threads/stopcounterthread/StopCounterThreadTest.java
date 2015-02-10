package com.sirma.itt.javacourse.threads.stopcounterthread;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link StopCounterThreadTest} tests the main method of the class
 * {@link StopCounterThread} with sample input.
 */
public class StopCounterThreadTest {
	private CounterThread counterThread = new CounterThread();

	/**
	 * Tests the main method of the class {@link StopCounterThread} with sample input.
	 */
	@Test
	public void test() {
		new Thread(counterThread).start();
		try {
			Thread.sleep(5100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int expected = 5;
		int actual = counterThread.getCounter();
		assertEquals(expected, actual);
	}

}
