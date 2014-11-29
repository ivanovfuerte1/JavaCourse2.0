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
 *            the key to an element that can be saved in the cache
 * @param <V>
 *            the element that can be saved in the cache
 */
public class CacheMap<K, V> {
	private Queue<K> queueOfKeys = new LinkedList<K>();
	private int maxCapacity;
	private final Map<K, V> cache = new LinkedHashMap<K, V>(maxCapacity, 1.0f, true);

	/**
	 * Constructs a cache with maximum capacity. It is used to memorize the most recently used
	 * elements in order to access them faster.
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
	 * key - the element becomes the most recently used.
	 * 
	 * @param key
	 *            the key to the element to refresh
	 * @return the value of the refreshed element
	 */
	public V get(K key) {
		queueOfKeys.remove(key);
		queueOfKeys.add(key);
		return cache.get(key);
	}

	/**
	 * Returns the updated map.
	 * 
	 * @return the updated map
	 */
	public Map<K, V> getMap() {
		return cache;
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
		V previous = cache.put(key, value);
		queueOfKeys.remove(key);
		queueOfKeys.add(key);

		if (cache.size() > maxCapacity) {
			K oldest = queueOfKeys.poll();
			cache.remove(oldest);
		}
		return previous;
	}

}
