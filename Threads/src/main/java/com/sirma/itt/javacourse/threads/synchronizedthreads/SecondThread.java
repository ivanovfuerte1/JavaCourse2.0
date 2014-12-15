package com.sirma.itt.javacourse.threads.synchronizedthreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link SecondThread} contains methods for running a counter thread, logging and
 * notifying the other thread every time the counter changes.
 */
public class SecondThread implements Runnable {
	private static final Logger LOGGER = LogManager.getLogger(SecondThread.class);
	private int initialCounterValue;
	private int finalCounterValue;
	private FirstThread firstThread;
	private static boolean timeToFinish = true;

	/**
	 * Constructs an object of the class {@link SecondThread} defining the initialCounterValue, the
	 * finalCounterValue and assigning a thread to notify.
	 * 
	 * @param initialCounterValue
	 *            the initial counter value
	 * @param finalCounterValue
	 *            the final counter value
	 * @param firstThread
	 *            the another thread to wait for
	 */
	public SecondThread(int initialCounterValue, int finalCounterValue, FirstThread firstThread) {
		this.initialCounterValue = initialCounterValue;
		this.finalCounterValue = finalCounterValue;
		this.firstThread = firstThread;
	}

	/**
	 * Notifies a waiting thread.
	 */
	public synchronized void notifyThread() {
		notify();
	}

	@Override
	public synchronized void run() {
		for (int i = initialCounterValue; i <= finalCounterValue; i++) {
			if (!timeToFinish) {
				try {
					wait();
				} catch (InterruptedException e) {
					LOGGER.error("The thread was interrupted while waiting.", e);
				}
			}
			timeToFinish = false;
			firstThread.notifyThread();
			LOGGER.info(i);
		}
		return;
	}

}
