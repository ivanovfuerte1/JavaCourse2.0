package com.sirma.itt.javacourse.threads.timeouttable;

import java.util.Hashtable;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link TimeoutHashtable} contains methods for associating specified values with the
 * specified keys in its map and removing a value associated with a specified key.
 */
public class TimeoutHashtable {
	private Map<String, Object> timeoutTable = new Hashtable<>();
	private static final Logger LOGGER = LogManager.getLogger(TimeoutHashtable.class);

	/**
	 * Returns the map containing values and keys associated with them.
	 * 
	 * @return the map containing values and keys associated with them
	 */
	public Map<String, Object> getTimeoutTable() {
		return timeoutTable;
	}

	/**
	 * Associates specified value with the specified key. If the map previously contained a mapping
	 * for the key, the old value is replaced by the specified value.
	 * 
	 * @param key
	 *            the specified key
	 * @param value
	 *            the specified value
	 */
	public synchronized void put(String key, Object value) {
		// XXX: Move logic for starting the thread here.
		LOGGER.info("The entry: " + key + ", value " + value + " added");
		timeoutTable.put(key, value);
	}

	/**
	 * Removes a value associated with the specified key.
	 * 
	 * @param key
	 *            the key associated with the value to remove
	 */
	public synchronized void remove(String key) {
		LOGGER.info("The entry: " + key + ", value " + timeoutTable.get(key) + " is being removed");
		timeoutTable.remove(key);
	}
}
