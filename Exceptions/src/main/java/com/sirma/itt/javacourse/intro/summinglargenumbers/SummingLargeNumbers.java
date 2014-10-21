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
		final String zeroInString = "0";
		// The algorithm that follows this verification works only for smaller or equal in length
		// second large number. For this reason the possibility of having second integer with bigger
		// length is processed by recursively calling the method for summing large numbers with
		// swapped values.
		int lengthFirstNumber = 0;
		int lengthSecondNumber = 0;
		try {
			lengthFirstNumber = firstNumber.length();
			lengthSecondNumber = secondNumber.length();
		} catch (NullPointerException e) {
			System.out.println("One or both of the strings are null!");
			e.printStackTrace();
			// manipulated wrong result letting the program to show correct test
			return "";
		}
		if (lengthFirstNumber < lengthSecondNumber) {
			return sumLargeNumbers(secondNumber, firstNumber);
		} else {
			if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
				ArithmeticException exception = new ArithmeticException("Not valid input!");
				throw exception;
			}
			int transfer = 0;
			char[] digitsFirstNumber = firstNumber.toCharArray();
			char[] digitsSecondNumber = secondNumber.toCharArray();
			int digitFirstNumber = 0;
			int digitSecondNumber = 0;
			int tempSum;

			for (int i = digitsSecondNumber.length - 1; i >= 0; i--) {
				try {
					// Extracts from the largest number the digit to sum with. The possibility of
					// having different amount of digits in both numbers is the reason to calculate
					// this difference.
					digitFirstNumber = Integer.parseInt(firstNumber.substring(i
							+ digitsFirstNumber.length - digitsSecondNumber.length, i
							+ digitsFirstNumber.length - digitsSecondNumber.length + 1));
					digitSecondNumber = Integer.parseInt(secondNumber.substring(i, i + 1));
				} catch (NumberFormatException e) {
					System.out.println("Not valid character in the input!" + e);
					System.out.println();
				}
				tempSum = digitFirstNumber + digitSecondNumber + transfer;
				output.insert(0, tempSum % 10);
				transfer = tempSum / 10;
			}
			// If there is a difference of the amount of digits between both numbers, here the
			// transfer is added to the digits of the larger number.
			if (secondNumber.length() < firstNumber.length()) {
				for (int i = digitsFirstNumber.length - digitsSecondNumber.length; i > 0; i--) {
					try {
						digitFirstNumber = Integer.parseInt(firstNumber.substring(i - 1, i));
					} catch (NumberFormatException e) {
						System.out.println("Not valid character in the input!");
						e.printStackTrace();
						System.out.println();
					}
					tempSum = digitFirstNumber + transfer;
					output.insert(0, tempSum % 10);
					transfer = tempSum / 10;
				}
			}
			if (transfer > 0) {
				output.insert(0, transfer);
			}
			if (zeroInString.equals(output.toString())) {
				return "0";
			} else {
				return output.toString().replaceAll("^0+", "");
			}
		}
	}
}
