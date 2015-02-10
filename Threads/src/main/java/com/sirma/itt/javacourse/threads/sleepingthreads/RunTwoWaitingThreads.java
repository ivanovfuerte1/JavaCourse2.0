package com.sirma.itt.javacourse.threads.sleepingthreads;

/**
 * The class {@link RunTwoWaitingThreads} contains a method for running two waiting threads
 * simultaneously.
 */
public final class RunTwoWaitingThreads {

	/**
	 * Runs two waiting threads simultaneously.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		Thread firstThread = new Thread(new WaitingThread(5, 10));
		Thread secondThread = new Thread(new WaitingThread(10, 20));
		firstThread.start();
		secondThread.start();
	}

}
