package com.sirma.itt.javacourse.threads.sleepingthreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link WaitingThread} contains a method for running a counter thread and logging every
 * time the counter changes. The thread notifies other threads for getting to the end by setting a
 * flag.
 */
public class WaitingThread implements Runnable {
	private static final Logger LOGGER = LogManager.getLogger(WaitingThread.class);
	private int initialCounterValue;
	private int finalCounterValue;
	private static boolean timeToFinish = false;

	/**
	 * Constructs an object of the class {@link WaitingThread} defining the initialCounterValue and
	 * the finalCounterValue.
	 * 
	 * @param initialCounterValue
	 *            the initial counter value
	 * @param finalCounterValue
	 *            the final counter value
	 */
	public WaitingThread(int initialCounterValue, int finalCounterValue) {
		this.initialCounterValue = initialCounterValue;
		this.finalCounterValue = finalCounterValue;
	}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = initialCounterValue; i < finalCounterValue; i++) {
				if (!timeToFinish) {
					LOGGER.info(Thread.currentThread().getName() + "The count is at: " + i);
					try {
						wait(1000);
					} catch (InterruptedException e) {
						LOGGER.error("The thread was interrupted while waiting.", e);
					}
				} else {
					return;
				}
			}
			timeToFinish = true;
			return;
		}
	}

}
