package com.sirma.itt.javacourse.threads.stopcounterthread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link CounterThread} contains a method for running a counter and stopping if the
 * thread is interrupted.
 */
public class CounterThread implements Runnable {

	private static final Logger LOGGER = LogManager.getLogger(CounterThread.class);

	@Override
	public void run() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				LOGGER.info("The count stopped at: " + i);
				e.printStackTrace();
				return;
			}
		}
	}

}
