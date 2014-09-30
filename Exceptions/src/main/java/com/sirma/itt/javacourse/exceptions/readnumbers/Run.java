package com.sirma.itt.javacourse.exceptions.readnumbers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class Run contains method for reading numbers from the console.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public final class Run {

	private static final Logger LOGGER = LogManager.getLogger(Run.class);

	/**
	 * Default constructor.
	 */
	private Run() {

	}

	/**
	 * Reads numbers from the console.
	 * 
	 * @param args
	 *            default arguments
	 * @throws OutOfRangeException
	 *             if the number is not in the range 0,100
	 */
	public static void main(String... args) throws OutOfRangeException {
		ReadingNumbersConsole arrayOfNumbers = new ReadingNumbersConsole(new ConsoleDataReader());
		try {
			arrayOfNumbers.readNumber();
		} catch (OutOfRangeException e1) {
			LOGGER.error("Your number is not between 0 and 100.", e1);
		}
	}

}
