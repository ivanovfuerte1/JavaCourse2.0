package com.sirma.itt.javacourse.intro.arrayprocessing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class tests sum method.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class SumTest {
	private int[] array = new int[] { 11, 12, 5, 6, 4, 55, 44, 33, 11, 9 };
	private int[] array2 = new int[] { -11, 12, 5, 6, -4, 55, 0, 33, 11, -9 };
	private int[] array3 = new int[] { 3 };
	private int[] array4 = new int[0];
	private int[] array5 = null;

	/**
	 * Test the sum method with positive integers.
	 */
	@Test
	public void test1() {
		int result = new ArrayProcessing().sum(array);
		assertEquals(190, result);
	}

	/**
	 * Test the sum method with array that contains zero and negatives.
	 */
	@Test
	public void test2() {
		int result = new ArrayProcessing().sum(array2);
		assertEquals(98, result);
	}

	/**
	 * Test the sum method with array that contains only one element.
	 */
	@Test
	public void test3() {
		int result = new ArrayProcessing().sum(array3);
		assertEquals(3, result);
	}

	/**
	 * Test the sum method with an empty array. It is assumed that the sum of zero or no elements is
	 * zero.
	 */
	@Test
	public void test4() {
		int result = new ArrayProcessing().sum(array4);
		assertEquals(0, result);
	}

	/**
	 * Test the sum method with a null array.
	 */
	@Test(expected = NullPointerException.class)
	public void test5() {
		new ArrayProcessing().sum(array5);
	}

}