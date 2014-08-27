package com.sirma.itt.javacourse.intro.quicksort;

import java.util.Arrays;

/**
 * The class QuickSort contains methods for sorting an array by quicksort.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class QuickSort {
	private int[] numbers;
	private int number;

	/**
	 * Checks for empty array and copies the values of the array into the default object in order to
	 * sort them.
	 * 
	 * @param values
	 *            the array of values for sorting
	 */
	public void preparingQuickSort(int[] values) {
		if (values.length < 1) {
			throw new IllegalArgumentException("The array has no elements");
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}

	/**
	 * Sorts the array by quicksort. It uses the algorithm divide and conquer. A pivot is being
	 * selected to divide the array into two parts. The first one contains values smaller than the
	 * pivot and the other - the rest. The division is recursive.
	 * 
	 * @param left
	 *            the leftmost element of the array presented as a horizontal set of values
	 * @param right
	 *            the rightmost element of the array presented as a horizontal set of values
	 */
	private void quicksort(int left, int right) {
		int i = left;
		int j = right;
		int[] arrayToChosePivot = new int[] { numbers[left], numbers[left + (right - left) / 2],
				numbers[right] };
		Arrays.sort(arrayToChosePivot);
		int pivot = arrayToChosePivot[1];
		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}
			if (i <= j) {
				// Swaps the values when they are not in the correct place. It means values smaller
				// than the pivot should stay on its left and greater values on its right in an
				// array presented as a horizontal set of values.
				swapElements(i, j);
				i++;
				j--;
			}
		}
		if (left < j) {
			quicksort(left, j);
		}
		if (i < right) {
			quicksort(i, right);
		}
	}

	/**
	 * Swaps two values of an array.
	 * 
	 * @param firstValue
	 *            the first value (before swapping)
	 * @param secondValue
	 *            the second value (before swapping)
	 */
	private void swapElements(int firstValue, int secondValue) {
		int temp = numbers[firstValue];
		numbers[firstValue] = numbers[secondValue];
		numbers[secondValue] = temp;
	}
}
