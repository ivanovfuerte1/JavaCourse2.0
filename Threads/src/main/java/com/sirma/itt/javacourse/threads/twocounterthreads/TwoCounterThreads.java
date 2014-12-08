package com.sirma.itt.javacourse.threads.twocounterthreads;

/**
 * The class {@link TwoCounterThreads} contains a method for running two counter threads.
 */
public final class TwoCounterThreads {
	/**
	 * Default constructor.
	 */
	private TwoCounterThreads() {
	}

	/**
	 * Runs two counter threads simultaneously.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		Thread firstThread = new Thread(new CounterThreads(5, 10));
		Thread secondThread = new Thread(new CounterThreads(10, 20));
		firstThread.start();
		secondThread.start();
	}

}
