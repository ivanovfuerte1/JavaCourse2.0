package com.sirma.itt.javacourse.intro.quicksort;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * This class implements tests for the methods of the program QuickSort with sample arrays.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class QuickSortTest {

	/**
	 * Tests the methods of QuickSort with an array of positive numbers.
	 */
	@Test
	public void test1() {
		QuickSort sorter = new QuickSort();
		int[] testingArray = { 4, 11, 2, 7, 1, 9, 3, 5, 10, 6, 8, 12 };
		sorter.preparingQuickSort(testingArray);
		if (!validate(testingArray)) {
			fail("Should not happen");
		}
		printResult(testingArray);
	}

	/**
	 * Tests the methods of QuickSort with an array of numbers containing zero and negatives.
	 */
	@Test
	public void test2() {
		QuickSort sorter = new QuickSort();
		int[] testingArray = { 5, -88, 11, 0, 1000, -7 };
		sorter.preparingQuickSort(testingArray);
		if (!validate(testingArray)) {
			fail("Should not happen");
		}
		printResult(testingArray);
	}

	/**
	 * Tests the methods of QuickSort with an array containing equal numbers.
	 */
	@Test
	public void test3() {
		QuickSort sorter = new QuickSort();
		int[] testingArray = { 5, -88, -88, 0, 1000, 0 };
		sorter.preparingQuickSort(testingArray);
		if (!validate(testingArray)) {
			fail("Should not happen");
		}
		printResult(testingArray);
	}

	/**
	 * Checks if the array is sorted.
	 * 
	 * @param numbers
	 *            the array being checked
	 * @return true in case the array is sorted
	 */
	private boolean validate(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Prints the sorted array on the screen.
	 * 
	 * @param numbers
	 *            the array to display.
	 */
	private void printResult(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

}
