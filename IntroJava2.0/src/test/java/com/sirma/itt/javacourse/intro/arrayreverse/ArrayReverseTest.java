package com.sirma.itt.javacourse.intro.arrayreverse;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * This class tests the method arrayReverse of the class ArrayReverse.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class ArrayReverseTest {

	/**
	 * Tests the method arrayReverse with sample array of positive values.
	 */
	@Test
	public void test1() {
		int[] myArray = new int[] { 1, 2, 3, 4, 5 };
		List<int[]> list = Arrays.asList(myArray);
		Collections.reverse(list);
		List<int[]> resultingList = Arrays.asList(new ArrayReverse().arrayReverse(myArray));
		if (!list.equals(resultingList)) {
			fail("Should not happen");
		}
	}

	/**
	 * Tests the method arrayReverse with sample array that contains zero and negatives.
	 */
	@Test
	public void test2() {
		int[] myArray = new int[] { -1, 2, -103, 0, 5 };
		int[] expectedResult = new int[] { 5, 0, -103, 2, -1 };
		int[] result = new ArrayReverse().arrayReverse(myArray);
		assertArrayEquals(expectedResult, result);
	}
}
