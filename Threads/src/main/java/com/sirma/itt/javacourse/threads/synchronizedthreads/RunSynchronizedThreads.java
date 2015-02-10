package com.sirma.itt.javacourse.threads.synchronizedthreads;

/**
 * The class {@link RunSynchronizedThreads} contains a method for running two synchronized counter
 * threads.
 */
public final class RunSynchronizedThreads {

	/**
	 * Runs two synchronized counter threads simultaneously.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		SynchronizedThread firstThread = new SynchronizedThread(1, 5000, null);
		SynchronizedThread secondThread = new SynchronizedThread(1, 5000, firstThread);
		firstThread.register(secondThread);
		(new Thread(firstThread)).start();
		(new Thread(secondThread)).start();
	}

}
