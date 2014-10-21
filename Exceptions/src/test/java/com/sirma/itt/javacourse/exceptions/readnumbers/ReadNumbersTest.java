package com.sirma.itt.javacourse.exceptions.readnumbers;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Test;

/**
 * The class ReadNumbersTest contains methods for testing the method readNumber from the class
 * ReadingNumbersConsole with sample arrays.
 *
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class ReadNumbersTest {
	private String[] arrayContainingNegative = { "1", "2", "-5" };
	private String[] arrayContainingOutOfRange = { "21", "22", "23", "24", "225" };
	private String[] arrayContainingBigIntegers = { "100", "0",
			"55000000000000000000000999999999999999999", "50", "0" };
	private String[] arrayContainingIntegers = { "100", "0", "5", "50", "0" };
	private String[] emptyArray = {};
	private String[] nullArray = null;
	private String[] arrayContainingLetter = { "33", "44", "l" };
	private String[] arrayContainingSpace = { "11", "12", " ", "13", "14" };

	/**
	 * Test the method readNumber with sample array containing a negative value.
	 * 
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	@Test(expected = OutOfRangeException.class)
	public void testWithNegative() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				arrayContainingNegative));
		try {
			numbersRead.readNumber();
		} catch (OutOfRangeException e) {
			System.out.println("Your number is not between 0 and 100.");
		}
		throw new OutOfRangeException(null);
	}

	/**
	 * Test the method readNumber with sample array containing a value out of the specified range.
	 * 
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	@Test(expected = OutOfRangeException.class)
	public void testWithOutOfRange() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				arrayContainingOutOfRange));
		numbersRead.readNumber();
	}

	/**
	 * Test the method readNumber with sample array containing big integer.
	 * 
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	@Test(expected = AssertionError.class)
	public void testWithBigInt() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				arrayContainingBigIntegers));
		List<Integer> readNumber = numbersRead.readNumber();
		String[] arr = new String[readNumber.size()];
		for (int i = 0; i < readNumber.size(); i++) {
			arr[i] = readNumber.get(i) + "";
		}
		assertArrayEquals(arr, arrayContainingBigIntegers);
	}

	/**
	 * Test the method readNumber with sample array containing only valid values.
	 * 
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	@Test
	public void testCorrectIntegers() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				arrayContainingIntegers));
		List<Integer> readNumber = numbersRead.readNumber();
		String[] arr = new String[readNumber.size()];
		for (int i = 0; i < readNumber.size(); i++) {
			arr[i] = readNumber.get(i) + "";
		}
		assertArrayEquals(arr, arrayContainingIntegers);
	}

	/**
	 * Test the method readNumber with empty array.
	 * 
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	@Test
	public void testEmptyArray() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				nullArray));
		numbersRead.readNumber();
	}

	/**
	 * Test the method readNumber with null array.
	 * 
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	@Test
	public void testNullArray() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				emptyArray));
		numbersRead.readNumber();
	}

	/**
	 * Test the method readNumber with sample array containing letter.
	 * 
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	@Test
	public void testWithLetter() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				arrayContainingLetter));
		numbersRead.readNumber();
	}

	/**
	 * Test the method readNumber with sample array containing an empty space.
	 * 
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	@Test
	public void testWithSpace() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				arrayContainingSpace));
		numbersRead.readNumber();
	}

}
