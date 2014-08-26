package com.sirma.itt.javacourse.intro.summinglargenumbers;

/**
 * The class SummingLargeNumbers contains methods for summing large numbers represented in strings.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class SummingLargeNumbers {

	/**
	 * 
	 * Sums two large numbers given as strings.
	 * 
	 * @param firstLargeNumber
	 *            the first number from the input
	 * @param secondLargeNumber
	 *            the second number from the input
	 * @return the sum of the large numbers
	 */
	public String sumLargeNumbers(final String firstLargeNumber, String secondLargeNumber) {
		// XXX: comments!
		String output = "";
		// XXX: Comment! Why are you doing this?
		if (firstLargeNumber.length() < secondLargeNumber.length()) {
			return sumLargeNumbers(secondLargeNumber, firstLargeNumber);
		} else {
			// XXX: Why reverse the inputs? And if not using same variables why not define as final?
			String reverseFirstNumber = new StringBuffer(firstLargeNumber).reverse().toString();
			String reverseSecondNumber = new StringBuffer(secondLargeNumber).reverse().toString();
			
			int transfer = 0;
			char[] digitsFirstNumber = reverseFirstNumber.toCharArray();
			char[] digitsSecondNumber = reverseSecondNumber.toCharArray();
			int currentDigitFirstNumber;
			int currentDigitSecondNumber;
			int tempSum;

			for (int i = 0; i < digitsSecondNumber.length; i++) {
				currentDigitFirstNumber = Character.getNumericValue(digitsFirstNumber[i]);
				currentDigitSecondNumber = Character.getNumericValue(digitsSecondNumber[i]);
				tempSum = currentDigitFirstNumber + currentDigitSecondNumber + transfer;
				output += tempSum % 10;
				transfer = tempSum / 10;
			}
			if (secondLargeNumber.length() < firstLargeNumber.length()) {
				for (int i = digitsSecondNumber.length; i < digitsFirstNumber.length; i++) {
					currentDigitFirstNumber = Character.getNumericValue(digitsFirstNumber[i]);
					tempSum = currentDigitFirstNumber + transfer;
					output += tempSum % 10;
					transfer = tempSum / 10;
				}
			} else {
				if (transfer > 0) {
					output += transfer;
				}
			}
			output = new StringBuffer(output).reverse().toString();
			return output;
		}
	}
	
	public static void main(String[] args) {
		SummingLargeNumbers summingLargeNumbers = new SummingLargeNumbers();
		
		System.out.println(summingLargeNumbers.sumLargeNumbers("9999", "9"));
		
		System.out.println(summingLargeNumbers.sumLargeNumbers("9999", "1"));
		
		System.out.println(summingLargeNumbers.sumLargeNumbers("00000", "1"));
	}

}
