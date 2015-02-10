package com.sirma.itt.javacourse.threads.twocounterthreads;

/**
 * The class {@link RunTwoCounterThreads} contains a method for running several counter threads.
 */
public final class RunTwoCounterThreads {

	/**
	 * Runs several counter threads simultaneously.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		CounterThreads firstThread = new CounterThreads(5, 10);
		CounterThreads secondThread = new CounterThreads(10, 20);
		CounterThreads thirdThread = new CounterThreads(110, 120);
		CounterThreads fourthThread = new CounterThreads(210, 220);
		firstThread.start();
		secondThread.start();
		thirdThread.start();
		fourthThread.start();
	}

}
