package com.sirma.itt.javacourse.collections.lrucache;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * The class {@link LRUCacheTest} contains tests for the methods of the class {@link LRUCache}.
 * 
 * @author Svetlosar Kovatchev
 */
public class LRUCacheTest {

	/**
	 * Tests the methods of the class {@link LRUCache} by accessing an elder element and then
	 * checking if it is refreshed.
	 */
	@Test
	public void test() {
		CacheMap<Integer, String> testCache = new CacheMap<Integer, String>(3);
		testCache.put(0, "D");
		testCache.put(1, "E");
		testCache.put(2, "V");
		testCache.put(3, "E");
		testCache.put(4, "L");
		testCache.put(5, "O");
		testCache.put(6, "P");
		testCache.put(7, "E");
		testCache.get(5);
		testCache.put(8, "R");
		Map<Integer, String> delegate = new LinkedHashMap<>();
		delegate.put(7, "E");
		delegate.put(5, "O");
		delegate.put(8, "R");
		assertEquals(delegate, testCache.getMap());
	}
}
