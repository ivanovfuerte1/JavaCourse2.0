package com.sirma.itt.javacourse.collections.lrucache;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * The class {@link CacheMap} contains methods for caching instances by specified key using the LRU
 * algorithm.
 * 
 * @author Svetlosar Kovatchev
 * @param <K>
 * @param <V>
 */
public class CacheMap<K, V> {
	private Queue<K> keyInsertionOrder = new LinkedList<K>();
	private int maxCapacity;
	private final Map<K, V> delegate = new LinkedHashMap<K, V>(maxCapacity, 0.75f, true);

	/**
	 * Constructs a cache with maximum capacity.
	 * 
	 * @param maxCapacity
	 *            the maximum capacity
	 */
	public CacheMap(int maxCapacity) {
		if (maxCapacity < 1) {
			throw new IllegalArgumentException("Capacity must be greater than 0");
		}
		this.maxCapacity = maxCapacity;
	}

	/**
	 * Returns an existing key of the map. It also refreshes the element of the map with the given
	 * key.
	 * 
	 * @param key
	 *            the key to the element to refresh
	 * @return the value of the refreshed element
	 */
	public V get(K key) {
		keyInsertionOrder.remove(key);
		keyInsertionOrder.add(key);
		return delegate.get(key);
	}

	/**
	 * Returns the updated map.
	 * 
	 * @return the updated map
	 */
	public Map<K, V> getMap() {
		return delegate;
	}

	/**
	 * Adds an element to the map and removes the oldest if the cache is full.
	 * 
	 * @param key
	 *            the key of the new element
	 * @param value
	 *            the value of the new element
	 * @return the new element added if it already existed in the cache, otherwise returns null
	 */
	public V put(K key, V value) {
		V previous = delegate.put(key, value);
		keyInsertionOrder.remove(key);
		keyInsertionOrder.add(key);

		if (delegate.size() > maxCapacity) {
			K oldest = keyInsertionOrder.poll();
			delegate.remove(oldest);
		}
		return previous;
	}

}
