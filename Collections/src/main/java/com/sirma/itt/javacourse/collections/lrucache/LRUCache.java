package com.sirma.itt.javacourse.collections.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The class {@link LRUCache} implements a method for caching instances using LRU algorithm.
 * 
 * @author Svetlosar Kovatchev
 */
public class LRUCache {
	private static final int SIZE_OF_CACHE = 3;
	private Map<Integer, String> cache = new LinkedHashMap<Integer, String>(SIZE_OF_CACHE, 0.75f,
			true) {
		
		private static final long serialVersionUID = 13135519790447313L;

		@Override
		protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
			return size() > SIZE_OF_CACHE;
		}
	};

	/**
	 * Getter method for cache.
	 *
	 * @return the cache
	 */
	public Map<Integer, String> getCache() {
		return cache;
	}

	/**
	 * Setter method for cache.
	 *
	 * @param cache
	 *            the cache to set
	 */
	public void setCache(Map<Integer, String> cache) {
		this.cache = cache;
	}
}
