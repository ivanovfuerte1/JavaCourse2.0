package com.sirma.itt.javacourse.intro.summinglargenumbers;

/**
 * The class SummingLargeNumbers contains methods for summing large numbers represented in strings.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class SummingLargeNumbers {

	/**
	 * Sums two large numbers given as strings.
	 * 
	 * @param firstNumber
	 *            the first number from the input
	 * @param secondNumber
	 *            the second number from the input
	 * @return the sum of the large numbers
	 */
	public String sumLargeNumbers(final String firstNumber, final String secondNumber) {
		// A string is initialized as an empty string in order to concatenate the consecutive digits
		// to it.
		StringBuilder output = new StringBuilder();
		// The algorithm that follows this verification works only for smaller or equal in length
		// second large number. For this reason the possibility of having second integer with bigger
		// length is processed by recursively calling the method for summing large numbers with
		// swapped the values.
		if (firstNumber.length() < secondNumber.length()) {
			return sumLargeNumbers(secondNumber, firstNumber);
		} else {
			int transfer = 0;
			char[] digitsFirstNumber = firstNumber.toCharArray();
			char[] digitsSecondNumber = secondNumber.toCharArray();
			int digitFirstNumber;
			int digitSecondNumber;
			int tempSum;

			for (int i = digitsSecondNumber.length - 1; i >= 0; i--) {
				digitFirstNumber = Character.getNumericValue(digitsFirstNumber[i
						+ digitsFirstNumber.length - digitsSecondNumber.length]);
				digitSecondNumber = Character.getNumericValue(digitsSecondNumber[i]);
				tempSum = digitFirstNumber + digitSecondNumber + transfer;
				output.insert(0, tempSum % 10);
				transfer = tempSum / 10;
			}
			if (secondNumber.length() < firstNumber.length()) {
				for (int i = digitsFirstNumber.length - digitsSecondNumber.length; i > 0; i--) {
					digitFirstNumber = Character.getNumericValue(digitsFirstNumber[i - 1]);
					tempSum = digitFirstNumber + transfer;
					output.insert(0, tempSum % 10);
					transfer = tempSum / 10;
				}
			}
			if (transfer > 0) {
				output.insert(0, transfer);
			}
			return output.toString().replaceAll("^0+", "");
		}
	}

}
