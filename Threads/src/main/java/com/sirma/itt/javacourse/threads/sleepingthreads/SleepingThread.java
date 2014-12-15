package com.sirma.itt.javacourse.threads.sleepingthreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link SleepingThread} contains a method for running a counter thread and logging every
 * time the counter changes. The thread notifies other threads for getting to the end by setting a
 * flag.
 */
public class SleepingThread implements Runnable {
	private static final Logger LOGGER = LogManager.getLogger(SleepingThread.class);
	private int initialCounterValue;
	private int finalCounterValue;
	private static boolean timeToFinish = false;

	/**
	 * Constructs an object of the class {@link SleepingThread} defining the initialCounterValue and
	 * the finalCounterValue.
	 * 
	 * @param initialCounterValue
	 *            the initial counter value
	 * @param finalCounterValue
	 *            the final counter value
	 */
	public SleepingThread(int initialCounterValue, int finalCounterValue) {
		this.initialCounterValue = initialCounterValue;
		this.finalCounterValue = finalCounterValue;
	}

	@Override
	public synchronized void run() {
		for (int i = initialCounterValue; i < finalCounterValue; i++) {
			if (!timeToFinish) {
				LOGGER.info(Thread.currentThread().getName() + "The count is at: " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					LOGGER.error("The thread was interrupted while sleeping.", e);
				}
			} else {
				return;
			}
		}
		timeToFinish = true;
		return;
	}

}
