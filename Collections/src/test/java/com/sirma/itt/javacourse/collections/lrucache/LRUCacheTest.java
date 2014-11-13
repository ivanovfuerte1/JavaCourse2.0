package com.sirma.itt.javacourse.collections.lrucache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link LRUCacheTest} contains tests for the methods of the class {@link LRUCache}.
 * 
 * @author Svetlosar Kovatchev
 */
public class LRUCacheTest {
	// TESTS ARE NOT COMPLETE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	/**
	 * Tests the methods of the class {@link LRUCache} by accessing an elder element and then
	 * checking if it is refreshed.
	 */
	@Test
	public void test() {
		LRUCache testCache = new LRUCache();
		testCache.getCache().put(0, "D");
		testCache.getCache().put(1, "E");
		testCache.getCache().put(2, "V");
		testCache.getCache().put(3, "E");
		testCache.getCache().put(4, "L");
		testCache.getCache().put(5, "O");
		testCache.getCache().put(6, "P");
		testCache.getCache().put(7, "E");
		System.out.println(testCache.getCache().get(5));
		testCache.getCache().put(8, "R");
		System.out.println(testCache.getCache());
		String expected = null;
		String actual = null;
		assertEquals(expected, actual);
	}

	/**
	 * @Test public void test2() { LRUCache testCache = new LRUCache(cache);
	 *       testCache.setCache(cache); testCache.getCache().put(0, "H");
	 *       testCache.getCache().put(1, "E"); testCache.getCache().put(2, "L");
	 *       testCache.getCache().put(3, "L"); System.out.println(testCache.getCache().get(1));
	 *       testCache.getCache().put(4, "O"); System.out.println(testCache.getCache()); String
	 *       expected = null; String actual = null; assertEquals(expected, actual); }
	 */
	@Test
	public void test3() {
		String expected = null;
		String actual = null;
		assertEquals(expected, actual);
	}

	/**
	 * Tests the methods of the class {@link LRUCache} by accessing an elder element and then
	 * checking if it is refreshed.
	 */
	@Test
	public void test4() {
		CacheMap<Integer, String> testCache = new CacheMap<Integer, String>(3);
		testCache.put(0, "D");
		testCache.put(1, "E");
		testCache.put(2, "V");
		testCache.put(3, "E");
		testCache.put(4, "L");
		testCache.put(5, "O");
		System.out.println(testCache.put(5, "O"));
		testCache.put(6, "P");
		testCache.put(7, "E");
		System.out.println(testCache.get(5));
		testCache.put(8, "R");
		System.out.println(testCache.getMap());
		String expected = null;
		String actual = null;
		assertEquals(expected, actual);
	}
}
