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
		int leftPart;
		int rightPart;
		int difference;
		int minDifference = Integer.MAX_VALUE;
		int medianElement = 0;
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		for (int i = 0; i < array.length; i++) {
			leftPart = 0;
			rightPart = 0;
			for (int j = 0; j < i; j++) {
				leftPart += array[j];
			}
			rightPart = sum - leftPart - array[i];
			difference = Math.abs(leftPart - rightPart);
			if (difference < minDifference) {
				minDifference = difference;
				medianElement = i + 1;
			}
		}
		return medianElement;
	}

}