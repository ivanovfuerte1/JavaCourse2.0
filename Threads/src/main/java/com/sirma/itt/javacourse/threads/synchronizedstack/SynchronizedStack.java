package com.sirma.itt.javacourse.threads.synchronizedstack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link SynchronizedStack} contains methods for adding new elements to a list, removing
 * the last element of the list and printing all the elements to the screen.
 */
public class SynchronizedStack {
	private static int capacity;
	private static int count;
	private static Object[] array;
	private static final Logger LOGGER = LogManager.getLogger(SynchronizedStack.class);

	/**
	 * Returns the array.
	 *
	 * @return the array
	 */
	public Object[] getArray() {
		return array;
	}

	/**
	 * Constructs an object of the class {@link SynchronizedStack} with given array and its initial
	 * count of non-null elements.
	 * 
	 * @param array
	 *            the array from the input
	 * @param count
	 *            the number of non-null elements
	 */
	public SynchronizedStack(Object[] array, int count) {
		SynchronizedStack.array = array;
		SynchronizedStack.count = count;
		SynchronizedStack.capacity = array.length;
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param item
	 *            the element to add
	 */
	public synchronized void add(Object item) {
		while (count == capacity) {
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.error(
						"a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity",
						e);
			}
		}
		array[count++] = item;
		notifyAll();
	}

	/**
	 * Removes the last element of the array.
	 */
	public synchronized void remove() {
		while (count == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				LOGGER.error(
						"a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity",
						e);
			}
		}
		array[--count] = null;
		notifyAll();
	}

	/**
	 * Displays the elements of the array.
	 */
	public synchronized void print() {
		for (int i = 0; i < array.length; i++) {
			LOGGER.info(array[i]);
		}
	}

}