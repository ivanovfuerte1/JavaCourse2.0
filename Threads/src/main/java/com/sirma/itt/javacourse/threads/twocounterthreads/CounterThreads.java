package com.sirma.itt.javacourse.threads.twocounterthreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link CounterThreads} contains a method for running a counter thread and logging every
 * time the counter changes. The thread notifies other threads for getting to the end by setting a
 * flag.
 */
public class CounterThreads implements Runnable {
	private static final Logger LOGGER = LogManager.getLogger(CounterThreads.class);
	private int initialCounterValue;
	private int finalCounterValue;
	// XXX: variable name
	private static boolean timeToFinish = false;

	/**
	 * Constructs an object of the class {@link CounterThreads} defining the initialCounterValue and
	 * the finalCounterValue.
	 * 
	 * @param initialCounterValue
	 *            the initial counter value
	 * @param finalCounterValue
	 *            the final counter value
	 */
	public CounterThreads(int initialCounterValue, int finalCounterValue) {
		this.initialCounterValue = initialCounterValue;
		this.finalCounterValue = finalCounterValue;
	}

	@Override
	public void run() {
		for (int i = initialCounterValue; i < finalCounterValue; i++) {
			if (!timeToFinish) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					LOGGER.error("The thread was interrupted while sleeping.", e);
				}
				LOGGER.info(Thread.currentThread().getName() + " The count is at: " + i);
			} else {
				return;
			}
		}
		// is this thread safe?
		timeToFinish = true;
		return;
	}

}
