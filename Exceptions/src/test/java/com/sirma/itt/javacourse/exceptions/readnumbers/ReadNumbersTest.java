package com.sirma.itt.javacourse.exceptions.readnumbers;

import static org.junit.Assert.assertArrayEquals;

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
	public void testWithLetter1() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				arrayContainingNegative));
		try {
			numbersRead.readNumber();
		} catch (OutOfRangeException e) {
			System.out.println("Your number is not between 0 and 100.");
			// e.printStackTrace();
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
	public void testWithLetter2() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				arrayContainingOutOfRange));
		try {
			numbersRead.readNumber();
		} catch (OutOfRangeException e) {
			System.out.println("Your number is not between 0 and 100.");
			// e.printStackTrace();
		}
		throw new OutOfRangeException(null);
	}

	/**
	 * Test the method readNumber with sample array containing only valid values.
	 * 
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	@Test
	public void testWithLetter3() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				arrayContainingIntegers));
		String[] result = numbersRead.readNumber();
		assertArrayEquals(arrayContainingIntegers, result);
	}

	/**
	 * Test the method readNumber with empty array.
	 * 
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	@Test
	public void testWithLetter4() throws OutOfRangeException {
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
	public void testWithLetter5() throws OutOfRangeException {
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
	public void testWithLetter6() throws OutOfRangeException {
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
	public void testWithLetter7() throws OutOfRangeException {
		ReadingNumbersConsole numbersRead = new ReadingNumbersConsole(new TestReadingNumbers(
				arrayContainingSpace));
		numbersRead.readNumber();
	}

}
