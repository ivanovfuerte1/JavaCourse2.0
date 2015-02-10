package com.sirma.itt.javacourse.threads.stopcounterthread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link CounterThread} contains a method for running a counter and stopping if the
 * thread is interrupted.
 */
public class CounterThread implements Runnable {
	private static final int MAX_VALUE = 20;
	private int i = 0;
	private static final Logger LOGGER = LogManager.getLogger(CounterThread.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		for (i = 0; i <= MAX_VALUE; i++) {
			try {
				LOGGER.info("The count is at: " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				LOGGER.info("The count stopped at: " + i, e);
				return;
			}
			if (i == MAX_VALUE) {
				System.exit(0);
			}
		}
	}

	/**
	 * Returns the value of the counter.
	 * 
	 * @return the value of the counter
	 */
	public int getCounter() {
		return i;
	}

}
