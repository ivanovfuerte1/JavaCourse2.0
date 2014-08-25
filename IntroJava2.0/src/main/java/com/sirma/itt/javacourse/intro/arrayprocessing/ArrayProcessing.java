package com.sirma.itt.javacourse.intro.arrayprocessing;

/**
 * <br>
 * The class ArrayProcessing contains methods that:</br> <br>
 * 1.return the index of the element with minimum value.</br> <br>
 * 2.return the sum of all elements in the array.</br> <br>
 * 3.print the array's elements to screen.</br>
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class ArrayProcessing {

	/**
	 * Returns the index of the element with minimum value.
	 * 
	 * @param array
	 *            the given array
	 * @return the index of the minimum value
	 */
	public int getMinElement(int[] array) {
		int min = array[0];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				index = i;
			}
		}
		return index;
	}

	/**
	 * Calculates the sum of all elements in the array.
	 * 
	 * @param array
	 *            the given array
	 * @return the sum of all elements
	 */
	public int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	/**
	 * Prints the array's elements to screen.
	 * 
	 * @param array
	 *            the given array
	 */
	public static void print(int[] array) {
		if (array.length > 0) {
			if (array.length > 1) {
				for (int i = 0; i < array.length - 1; i++) {
					System.out.print(array[i]);
					System.out.print(", ");
				}
			}
			System.out.println(array[array.length - 1]);
		} else {
			System.out.println("The array has no elements.");
		}
	}

}