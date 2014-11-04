package com.sirma.itt.javacourse.libraries.arrays;

/**
 * The class ArraysPacked contains main method for testing the methods of ArrayProcessing,
 * ArrayMedian, QuickSort and ArrayReverse.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public final class ArraysPacked {
	/**
	 * Default constructor.
	 */
	private ArraysPacked() {
	}

	/**
	 * Tests the methods getMinElement, sum, findArraysMedian, preparingQuickSort and arrayReverse
	 * of ArrayProcessing, ArrayMedian, QuickSort and ArrayReverse from a jar file.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		int[] testArray = new int[] { 2, 4, 3, 1, 5 };
		System.out.println(new ArrayProcessing().getMinElement(testArray));
		System.out.println(new ArrayProcessing().sum(testArray));
		ArrayMedian arraymedian = new ArrayMedian();
		System.out.println(arraymedian.findArraysMedian(testArray));
		QuickSort quicksort = new QuickSort();
		quicksort.preparingQuickSort(testArray);
		for (int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + " ");
		}
		System.out.println();
		int[] testArrayReverse = new ArrayReverse().arrayReverse(testArray);
		for (int i = 0; i < testArray.length; i++) {
			System.out.print(testArrayReverse[i] + " ");
		}
		System.out.println();
	}

}
