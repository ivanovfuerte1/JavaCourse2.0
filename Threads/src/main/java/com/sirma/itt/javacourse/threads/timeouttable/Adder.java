package com.sirma.itt.javacourse.threads.timeouttable;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link Adder} contains methods for associating specified values with the specified keys
 * for one and a half seconds in its map and removing a value associated with a specified key.
 */
public class Adder extends Thread {
	private TimeoutHashtable timeoutHashtable;
	private Map<String, Object> timeoutTable;
	private String key;
	private static final Logger LOGGER = LogManager.getLogger(Adder.class);
	private static final int THREE_SECONDS = 3000;

	/**
	 * Constructs an element with specified value mapped to a specified key.
	 * 
	 * @param key
	 *            the key to map with the value
	 * @param value
	 *            the value to map with the key
	 * @param timeoutHashtable
	 *            the map containing the values associated with keys
	 */
	public Adder(String key, Object value, TimeoutHashtable timeoutHashtable) {
		this.timeoutHashtable = timeoutHashtable;
		this.timeoutTable = timeoutHashtable.getTimeoutTable();
		this.key = key;
	}

	@Override
	public synchronized void run() {
		try {
			wait(THREE_SECONDS);
			timeoutHashtable.remove(key);
		} catch (InterruptedException e) {
			LOGGER.error("The thread was interrupted while waiting.", e);
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or null if this map contains no
	 * mapping for the key. It also runs a new thread containing the new mapping so that it can have
	 * the same timeout as other threads.
	 * 
	 * @param key
	 *            the key associated with the value to erase
	 * @return the erased value
	 */
	public synchronized Object get(String key) {
		String tempKey = key;
		Object tempValue = timeoutTable.get(key);
		timeoutHashtable.remove(tempKey);
		notify();
		timeoutHashtable.put(tempKey, tempValue);
		return tempValue;
	}

}
