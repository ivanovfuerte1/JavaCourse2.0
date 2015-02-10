package com.sirma.itt.javacourse.threads.synchronizedthreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link SynchronizedThread} contains methods for running a counter thread, logging and
 * notifying the other thread every time the counter changes.
 */
public class SynchronizedThread implements Runnable {
	private int initialCounterValue;
	private int finalCounterValue;
	private SynchronizedThread synchronizedThread;
	private boolean timeToFinish = true;
	private static final Logger LOGGER = LogManager.getLogger(SynchronizedThread.class);

	/**
	 * Constructs an object of the class {@link SynchronizedThread} defining the
	 * initialCounterValue, the finalCounterValue and assigning a thread to notify.
	 * 
	 * @param initialCounterValue
	 *            the initial counter value
	 * @param finalCounterValue
	 *            the final counter value
	 * @param synchronizedThread
	 *            the another thread to wait for
	 */
	public SynchronizedThread(int initialCounterValue, int finalCounterValue,
			SynchronizedThread synchronizedThread) {
		this.initialCounterValue = initialCounterValue;
		this.finalCounterValue = finalCounterValue;
		this.synchronizedThread = synchronizedThread;
	}

	/**
	 * Registers another thread to wait for.
	 * 
	 * @param synchronizedThread
	 *            the another thread
	 */
	public void register(SynchronizedThread synchronizedThread) {
		this.synchronizedThread = synchronizedThread;
	}

	/**
	 * Notifies a waiting thread.
	 */
	public synchronized void notifyThread() {
		notify();
	}

	/**
	 * {@inheritDoc}
	 */
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
			synchronizedThread.notifyThread();
			LOGGER.info(i);
		}
		return;
	}

}
