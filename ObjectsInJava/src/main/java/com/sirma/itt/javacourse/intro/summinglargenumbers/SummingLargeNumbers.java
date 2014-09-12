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
	 * @param firstLargeNumber
	 *            the first number from the input
	 * @param secondLargeNumber
	 *            the second number from the input
	 * @return the sum of the large numbers
	 */
	public String sumLargeNumbers(final String firstLargeNumber, final String secondLargeNumber) {
		// A string is initialized as an empty string in order to concatenate the consecutive digits
		// to it.
		// XXX: Why do you use String what else can you use that can be more effective? 
		String output = "";
		// The algorithm that follows this verification works only for smaller or equal in length
		// second large number. For this reason the possibility of having second integer with bigger
		// length is processed by recursively calling the method for summing large numbers with
		// swapped the values.
		if (firstLargeNumber.length() < secondLargeNumber.length()) {
			return sumLargeNumbers(secondLargeNumber, firstLargeNumber);
		} else {
			int transfer = 0;
			char[] digitsFirstNumber = firstLargeNumber.toCharArray();
			char[] digitsSecondNumber = secondLargeNumber.toCharArray();
			int currentDigitFirstNumber;
			int currentDigitSecondNumber;
			int tempSum;

			for (int i = digitsSecondNumber.length - 1; i >= 0; i--) {
				currentDigitFirstNumber = Character.getNumericValue(digitsFirstNumber[i
						+ digitsFirstNumber.length - digitsSecondNumber.length]);
				currentDigitSecondNumber = Character.getNumericValue(digitsSecondNumber[i]);
				tempSum = currentDigitFirstNumber + currentDigitSecondNumber + transfer;
				output = tempSum % 10 + output;
				transfer = tempSum / 10;
			}
			if (secondLargeNumber.length() < firstLargeNumber.length()) {
				for (int i = digitsFirstNumber.length - digitsSecondNumber.length; i > 0; i--) {
					currentDigitFirstNumber = Character.getNumericValue(digitsFirstNumber[i - 1]);
					tempSum = currentDigitFirstNumber + transfer;
					output = tempSum % 10 + output;
					transfer = tempSum / 10;
				}
			}
			if (transfer > 0) {
				output = transfer + output;
			}
			return output;
		}
	}
	
	public static void main(String[] args) {
		SummingLargeNumbers sum = new SummingLargeNumbers();
		// XXX: trim leading zeros.
		String result = sum.sumLargeNumbers("0000000000009", "9999");
		System.out.println(result);
	}
}
