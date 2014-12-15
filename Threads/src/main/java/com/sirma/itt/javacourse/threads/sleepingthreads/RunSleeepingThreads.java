package com.sirma.itt.javacourse.threads.sleepingthreads;

/**
 * The class {@link RunSleeepingThreads} contains a method for running two sleeping threads
 * simultaneously.
 */
public final class RunSleeepingThreads {
	/**
	 * Default constructor.
	 */
	private RunSleeepingThreads() {
	}

	/**
	 * Runs two sleeping threads simultaneously.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		Thread thirdThread = new Thread(new SleepingThread(25, 30));
		Thread fourthThread = new Thread(new SleepingThread(30, 40));
		thirdThread.start();
		fourthThread.start();
	}

}
