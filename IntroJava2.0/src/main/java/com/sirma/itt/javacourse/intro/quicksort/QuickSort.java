package com.sirma.itt.javacourse.intro.quicksort;

import com.sirma.itt.javacourse.intro.arraymedian.ArrayMedian;

/**
 * The class QuickSort contains methods for sorting an array by quicksort.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class QuickSort extends ArrayMedian {
	private int[] numbers;
	private int number;

	/**
	 * Checks for empty array and copies the values of the array into the
	 * default object in order to sort them.
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
	 * Sorts the array by quicksort. It uses the algorithm divide and conquer. A
	 * pivot is being selected to divide the array into two parts. The first one
	 * contains values smaller than the pivot and the other - the rest. The
	 * division is recursive.
	 * 
	 * @param left
	 *            the leftmost element of the array presented as a horizontal
	 *            set of values
	 * @param right
	 *            the rightmost element of the array presented as a horizontal
	 *            set of values
	 */
	private void quicksort(int left, int right) {
		int i = left;
		int j = right;
		// XXX: Why choose this pivot?
		// The pivot is chosen to be the median amongst the first, middle and
		// last element
		int[] arrayToChosePivot = new int[] { numbers[left],
				numbers[left + (right - left) / 2], numbers[right] };
		int pivot = arrayToChosePivot[findArraysMedian(arrayToChosePivot) - 1];
		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}
			if (i <= j) {
				// 
				exchange(i, j);
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
	 * XXX: you use swap as comment but "exchange" as method name, why not
	 * change it to swapElements or swap? 
	 * 
	 * Swaps the values when they are not in
	 * the correct place. It means values smaller than the pivot should stay on
	 * its left and greater values on its right in an array presented as a
	 * horizontal set of values.
	 * 
	 * @param i
	 * 			  XXX: comments?
	 *            a value greater than the pivot (before swapping)
	 * @param j
	 *            XXX: comments?
	 *            a value smaller than the pivot (before swapping)
	 */
	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}