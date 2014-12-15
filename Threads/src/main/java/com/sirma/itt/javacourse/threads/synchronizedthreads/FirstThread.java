package com.sirma.itt.javacourse.threads.synchronizedthreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link FirstThread} contains methods for running a counter thread, logging and
 * notifying the other thread every time the counter changes.
 */
public class FirstThread implements Runnable {
	private static final Logger LOGGER = LogManager.getLogger(FirstThread.class);
	private int initialCounterValue;
	private int finalCounterValue;
	private SecondThread secondThread;
	private static boolean timeToFinish = false;

	/**
	 * Constructs an object of the class {@link FirstThread} defining the initialCounterValue and
	 * the finalCounterValue.
	 * 
	 * @param initialCounterValue
	 *            the initial counter value
	 * @param finalCounterValue
	 *            the final counter value
	 */
	public FirstThread(int initialCounterValue, int finalCounterValue) {
		this.initialCounterValue = initialCounterValue;
		this.finalCounterValue = finalCounterValue;
	}

	/**
	 * Registers another thread to wait for.
	 * 
	 * @param secondThread
	 *            the another thread
	 */
	public void register(SecondThread secondThread) {
		this.secondThread = secondThread;
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
			if (timeToFinish) {
				try {
					wait();
				} catch (InterruptedException e) {
					LOGGER.error("The thread was interrupted while waiting.", e);
				}
			}
			timeToFinish = true;
			secondThread.notifyThread();
			LOGGER.info(i);
		}
		return;
	}

}
