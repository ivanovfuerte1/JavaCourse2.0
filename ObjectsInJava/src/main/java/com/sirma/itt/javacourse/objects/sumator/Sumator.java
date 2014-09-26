package com.sirma.itt.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.sirma.itt.javacourse.intro.summinglargenumbers.SummingLargeNumbers;

/**
 * The class Sumator contains method for summing integer numbers, floating point numbers, numbers in
 * strings, and numbers in format BigInteger and BigDecimal.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class Sumator extends SummingLargeNumbers {

	/**
	 * The transfer from decimal to integer is used when necessary. Since the program works with two
	 * values the transfer, if any can only be 1.
	 */
	private static final String TRANSFER_DECIMAL_TO_INTEGER = "1";
	private boolean transferToInteger = false;

	/**
	 * Sums two integers.
	 * 
	 * @param a
	 *            the first integer
	 * @param b
	 *            the second integer
	 * @return The resulting sum of the integers
	 */
	public int sum(int a, int b) {
		int result = a + b;
		return result;
	}

	/**
	 * Sums two floating point numbers.
	 * 
	 * @param a
	 *            the first floating point number
	 * @param b
	 *            the second floating point number
	 * @return the resulting sum of the floating point numbers
	 */
	public float sum(float a, float b) {
		float result = a + b;
		return result;
	}

	/**
	 * Sums two integers in strings.
	 * 
	 * @param a
	 *            the first integer
	 * @param b
	 *            the second integer
	 * @return the resulting sum of both integers in strings
	 */
	public String sum(String a, String b) {
		String[] integersInString = new String[2];
		integersInString[0] = a;
		integersInString[1] = b;
		return sumLargeNumbers(integersInString[0], integersInString[1]);
	}

	/**
	 * Sums to big integers. In order to avoid repeating large amounts of code cast to BigDecimal is
	 * used. In case fast code is preferred some little modifications can be made.
	 * 
	 * @param a
	 *            the first big integer
	 * @param b
	 *            the second big integer
	 * @return the resulting sum of both big integers
	 */
	public BigInteger sum(BigInteger a, BigInteger b) {
		BigDecimal bigDecimalA = new BigDecimal(a);
		BigDecimal bigDecimalB = new BigDecimal(b);
		BigDecimal bigDecimalResult = sum(bigDecimalA, bigDecimalB);
		BigInteger result = bigDecimalResult.toBigInteger();
		return result;

	}

	/**
	 * Sums two big decimals.
	 * 
	 * @param a
	 *            the first big decimal
	 * @param b
	 *            the second big decimal
	 * @return the resulting sum of both big decimals
	 */
	public BigDecimal sum(BigDecimal a, BigDecimal b) {
		String firstBigDecimalString = a.toString();
		String secondBigDecimalString = b.toString();

		int firstDotIndex = firstBigDecimalString.indexOf(".");
		String firstIntegerPart = extractIntegerPart(firstBigDecimalString, firstDotIndex);
		String firstDecimalPart = extractDecimalPart(firstBigDecimalString, firstDotIndex);

		int secondDotIndex = secondBigDecimalString.indexOf(".");
		String secondIntegerPart = extractIntegerPart(secondBigDecimalString, secondDotIndex);
		String secondDecimalPart = extractDecimalPart(secondBigDecimalString, secondDotIndex);

		String result = sumLargeNumbers(firstIntegerPart, secondIntegerPart);
		String resultingSum = sumDecimalPart(firstDecimalPart, secondDecimalPart);
		if (transferToInteger) {
			result = sumLargeNumbers(TRANSFER_DECIMAL_TO_INTEGER, result);
		}
		result += ".";
		result += resultingSum;
		BigDecimal finalResult = new BigDecimal(result);
		return finalResult;
	}

	/**
	 * Sums the decimal parts of the decimal numbers.
	 * 
	 * @param firstDecimalString
	 *            the decimal part of the first number
	 * @param secondDecimalString
	 *            the decimal part of the second number
	 * @return the resulting sum of both decimal parts
	 */
	private String sumDecimalPart(String firstDecimalString, String secondDecimalString) {
		String output = "";
		int transfer = 0;
		if (firstDecimalString.length() < secondDecimalString.length()) {
			return sumDecimalPart(secondDecimalString, firstDecimalString);
		} else {
			char[] digitsFirstNumber = firstDecimalString.toCharArray();
			char[] digitsSecondNumber = secondDecimalString.toCharArray();
			int currentDigitFirstNumber;
			int currentDigitSecondNumber;
			int tempSum;
			for (int i = digitsFirstNumber.length - 1; i >= digitsSecondNumber.length; i--) {
				output = Character.getNumericValue(digitsFirstNumber[i]) + output;
			}
			for (int i = digitsSecondNumber.length - 1; i >= 0; i--) {
				currentDigitFirstNumber = Character.getNumericValue(digitsFirstNumber[i]);
				currentDigitSecondNumber = Character.getNumericValue(digitsSecondNumber[i]);
				tempSum = currentDigitFirstNumber + currentDigitSecondNumber + transfer;
				output = tempSum % 10 + output;
				transfer = tempSum / 10;
			}
		}
		if (transfer != 0) {
			transferToInteger = true;
		}
		return output;
	}

	/**
	 * Extracts the integer part of the decimal number.
	 * 
	 * @param bigIntegersInString
	 *            a string containing the big integer
	 * @param dotIndex
	 *            the index of the decimal point
	 * @return a substring containing the integer part
	 */
	private String extractIntegerPart(String bigIntegersInString, int dotIndex) {
		String integerPart;
		if (dotIndex != -1) {
			integerPart = bigIntegersInString.substring(0, dotIndex);
		} else {
			integerPart = bigIntegersInString;
		}
		return integerPart;
	}

	/**
	 * Extracts the decimal part of the decimal number.
	 * 
	 * @param bigIntegersInString
	 *            a string containing the big integer
	 * @param dotIndex
	 *            the index of the decimal point
	 * @return a substring containing the decimal part
	 */
	private String extractDecimalPart(String bigIntegersInString, int dotIndex) {
		String decimalPart = "";
		if (dotIndex != -1) {
			decimalPart = bigIntegersInString.substring(dotIndex + 1, bigIntegersInString.length());
		}
		return decimalPart;
	}
}
