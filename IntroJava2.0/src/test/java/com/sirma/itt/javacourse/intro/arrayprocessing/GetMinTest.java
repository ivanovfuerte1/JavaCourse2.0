package com.sirma.itt.javacourse.intro.arrayprocessing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class tests the getMinElement method.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class GetMinTest {
	private int[] array = new int[] { 11, 12, 5, 6, 4, 55, 44, 33, 11, 9 };
	private int[] array2 = new int[] { -11, 12, 5, 6, -4, 55, 0, 33, 11, -9 };
	private int[] array3 = new int[] { 3 };
	private int[] array4 = new int[5];
	private int[] array5 = null;

	/**
	 * Tests method getMinElement with positive integers.
	 */
	@Test
	public void test1() {
		int result = new ArrayProcessing().getMinElement(array);
		assertEquals(4, result);
	}

	/**
	 * Tests method getMinElement with negative integers and zero.
	 */
	@Test
	public void test2() {
		int result = new ArrayProcessing().getMinElement(array2);
		assertEquals(0, result);
	}

	/**
	 * Tests method getMinElement with an array with one element.
	 */
	@Test
	public void test3() {
		int result = new ArrayProcessing().getMinElement(array3);
		assertEquals(0, result);
	}

	/**
	 * Tests method getMinElement with an array with null elements.
	 */
	@Test
	public void test4() {
		int result = new ArrayProcessing().getMinElement(array4);
		assertEquals(0, result);
	}

	/**
	 * Test the sum method with a null array.
	 */
	@Test(expected = NullPointerException.class)
	public void test5() {
		new ArrayProcessing().getMinElement(array5);
	}

}