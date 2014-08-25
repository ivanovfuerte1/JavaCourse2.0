package com.sirma.itt.javacourse.intro.arraymedian;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class tests the findArraysMedian method of ArrayMedian class.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */

public class ArrayMedianTest {

	/**
	 * Tests the findArraysMedian method with sample values.
	 */
	@Test
	public void test1() {
		int[] array2 = new int[] { 4, 5, 99, -1, 5, 6 };
		int result = new ArrayMedian().findArraysMedian(array2);
		assertEquals(3, result);
	}

	/**
	 * Tests the findArraysMedian method with different values.
	 */
	@Test
	public void test2() {
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		int result = new ArrayMedian().findArraysMedian(array);
		assertEquals(4, result);
	}

	/**
	 * Tests the findArraysMedian method with values containing zero and negatives.
	 */
	@Test
	public void test3() {
		int[] array = new int[] { -1, 2, 0, 4, -5 };
		int result = new ArrayMedian().findArraysMedian(array);
		assertEquals(2, result);
	}

	/**
	 * Tests the findArraysMedian method with one negative element.
	 */
	@Test
	public void test4() {
		int[] array = new int[] { -5 };
		int result = new ArrayMedian().findArraysMedian(array);
		assertEquals(1, result);
	}

	/**
	 * Tests the findArraysMedian method with an array with no elements.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test5() {
		int[] array = new int[0];
		new ArrayMedian().findArraysMedian(array);
	}

	/**
	 * Tests the findArraysMedian method with a null array.
	 */
	@Test(expected = NullPointerException.class)
	public void test6() {
		int[] array = null;
		new ArrayMedian().findArraysMedian(array);
	}

	/**
	 * Tests the findArraysMedian method with an array with negative size.
	 */
	@Test(expected = NegativeArraySizeException.class)
	public void test7() {
		int[] array = new int[-5];
		new ArrayMedian().findArraysMedian(array);
	}

}
