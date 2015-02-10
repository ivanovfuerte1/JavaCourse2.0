package com.sirma.itt.javacourse.threads.twocounterthreads;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link CounterThreads} contains a method for running a counter thread and logging every
 * time the counter changes. The thread notifies other threads for getting to the end by setting a
 * flag.
 */
public class CounterThreads extends Thread {
	private static final Logger LOGGER = LogManager.getLogger(CounterThreads.class);
	private int initialCounterValue;
	private int finalCounterValue;
	private int counter;
	private static AtomicBoolean aThreadFinished = new AtomicBoolean();

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		for (counter = initialCounterValue; counter < finalCounterValue; counter++) {
			if (!aThreadFinished.get()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					LOGGER.error("The thread was interrupted while sleeping.", e);
				}
				LOGGER.info(Thread.currentThread().getName() + " The count is at: " + counter);
			} else {
				return;
			}
		}
		aThreadFinished.set(true);
		return;
	}

	/**
	 * Returns the counter.
	 * 
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

}
