package com.sirma.itt.javacourse.intro.arraymedian;

/**
 * The class ArrayMedian contains a method for finding the median element of an array.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class ArrayMedian {

	/**
	 * Returns the median of an array.
	 * 
	 * @param array
	 *            the array which median is needed
	 * @return the median of the array
	 */
	public int findArraysMedian(int[] array) {
		if (array.length < 1) {
			throw new IllegalArgumentException("The array has no elements");
		}
		int sumLeftPartElements = 0;
		int sumRightPartElements;
		int difference;
		int minDifference = Integer.MAX_VALUE;
		int indexMedidianElement = 0;
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		sumRightPartElements = sum;
		for (int i = 0; i < array.length; i++) {
			sumLeftPartElements = (i != 0) ? (sumLeftPartElements + array[i - 1]) : 0;
			sumRightPartElements -= array[i];
			sumRightPartElements = sum - sumLeftPartElements - array[i];
			difference = Math.abs(sumLeftPartElements - sumRightPartElements);
			if (difference < minDifference) {
				minDifference = difference;
				indexMedidianElement = i + 1;
			}
		}
		return indexMedidianElement;
	}

}
