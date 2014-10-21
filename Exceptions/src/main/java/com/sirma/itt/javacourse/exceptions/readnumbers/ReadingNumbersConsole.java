package com.sirma.itt.javacourse.exceptions.readnumbers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

/**
 * The method ReadingNumbersConsole contains a method for reading numbers from 0 to 100.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class ReadingNumbersConsole {
	private DataReader reader;

	/**
	 * Assigns data to the default object.
	 * 
	 * @param reader
	 *            the reader for the current input
	 */
	public ReadingNumbersConsole(DataReader reader) {
		this.reader = reader;
	}

	/**
	 * Reads numbers from the console.
	 * 
	 * @return the number read
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	public List<Integer> readNumber() throws OutOfRangeException {
		List<Integer> integerCollection = new ArrayList<Integer>();
		int currentInteger;
		do {
			try {
				System.out
						.println("Please enter an integer between 0 and 100 or press Enter to exit.");
				String data = reader.readUserInput();
				if ("".equals(data)) {
					break;
				}
				currentInteger = Integer.parseInt(data);
				if (currentInteger >= 0 && currentInteger < 101) {
					integerCollection.add(currentInteger);
					for (Iterator<Integer> iterator = integerCollection.iterator(); iterator
							.hasNext();) {
						Integer integer = (Integer) iterator.next();
						System.out.println(integer);
					}
				} else {
					System.out.println("Input stream closed.");
					throw new OutOfRangeException("Your number is not between 0 and 100.");
				}
			} catch (InputMismatchException e) {
				System.out.println("The input contains invalid characters." + e);
				break;
			} catch (NumberFormatException e) {
				System.out.println("The input contains invalid characters." + e);
				break;
			}
		} while (true);
		return integerCollection;
	}
}
