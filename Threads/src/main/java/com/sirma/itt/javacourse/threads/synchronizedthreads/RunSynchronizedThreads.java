package com.sirma.itt.javacourse.threads.synchronizedthreads;

/**
 * The class {@link RunSynchronizedThreads} contains a method for running two counter threads.
 */
public final class RunSynchronizedThreads {
	/**
	 * Default constructor.
	 */
	private RunSynchronizedThreads() {
	}

	/**
	 * Runs two counter threads simultaneously.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		FirstThread firstInitializingThread = new FirstThread(1, 5);
		SecondThread secondInitializingThread = new SecondThread(1, 5, firstInitializingThread);
		firstInitializingThread.register(secondInitializingThread);
		Thread firstThread = new Thread(firstInitializingThread);
		Thread secondThread = new Thread(secondInitializingThread);
		firstThread.start();
		secondThread.start();
	}

}
