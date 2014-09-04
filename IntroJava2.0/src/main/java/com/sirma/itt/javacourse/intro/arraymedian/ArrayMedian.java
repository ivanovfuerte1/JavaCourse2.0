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
		int leftSum = 0;
		int rightSum;
		int difference;
		int minDifference;
		int indexMedidianElement = 0;
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		rightSum = sum;
		minDifference = Math.abs(sum - array[0]);
		rightSum -= array[0];
		for (int i = 1; i < array.length; i++) {
			leftSum = leftSum + array[i - 1];
			rightSum -= array[i];
			difference = Math.abs(leftSum - rightSum);
			if (difference < minDifference) {
				minDifference = difference;
				indexMedidianElement = i;
			}
		}
		return ++indexMedidianElement;
	}

}
