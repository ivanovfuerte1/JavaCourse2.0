package com.sirma.itt.javacourse.threads.stopcounterthread;

/**
 * The class {@link RunStopCounterThread} tests the method waitForInput of the class
 * {@link StopCounterThread}.
 */
public final class RunStopCounterThread {

	/**
	 * Tests the method waitForInput of the class {@link StopCounterThread}.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		new StopCounterThread().waitForInput();
	}

}
