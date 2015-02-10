package com.sirma.itt.javacourse.threads.sleepingthreads;

/**
 * The class {@link RunSleeepingThreads} contains a method for running two sleeping threads
 * simultaneously.
 */
public final class RunSleeepingThreads {

	/**
	 * Runs two sleeping threads simultaneously.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		Thread thirdThread = new Thread(new WaitingThread(25, 30));
		Thread fourthThread = new Thread(new WaitingThread(30, 40));
		thirdThread.start();
		fourthThread.start();
	}

}
