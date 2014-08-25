package com.sirma.itt.javacourse.intro.arrayreverse;

/**
 * The class ArrayReverse contains a method that reverses the elements of an array.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class ArrayReverse {

	/**
	 * Reverses the elements of an array.
	 * 
	 * @param myArray
	 *            an array from the input
	 * @return the new reversed array
	 */
	public int[] arrayReverse(int[] myArray) {
		int temp = 0;
		for (int i = 0; i < myArray.length / 2; i++) {
			temp = myArray[i];
			myArray[i] = myArray[myArray.length - i - 1];
			myArray[myArray.length - i - 1] = temp;
		}
		return myArray;
	}
}
