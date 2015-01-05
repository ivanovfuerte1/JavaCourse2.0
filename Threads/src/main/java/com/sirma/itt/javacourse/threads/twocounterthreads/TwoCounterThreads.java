package com.sirma.itt.javacourse.threads.twocounterthreads;

/**
 * The class {@link TwoCounterThreads} contains a method for running several counter threads.
 */
public final class TwoCounterThreads {
	/**
	 * Default constructor.
	 */
	private TwoCounterThreads() {
	}

	/**
	 * Runs several counter threads simultaneously.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		Thread firstThread = new Thread(new CounterThreads(0, 11));
		Thread secondThread = new Thread(new CounterThreads(0, 200));
		Thread thirdThread = new Thread(new CounterThreads(110, 120));
		Thread fourthThread = new Thread(new CounterThreads(210, 220));
		firstThread.start();
		secondThread.start();
		//thirdThread.start();
		//fourthThread.start();
	}

}
