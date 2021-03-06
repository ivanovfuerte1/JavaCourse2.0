package com.sirma.itt.javacourse.intro.hangman;

import java.util.Scanner;

/**
 * The class ConsoleDataReader contains a method for reading from the console.
 * 
 * @author Svetlosar Kovatchev
 * @version 3.0
 */
public class ConsoleDataReader implements DataReader {
	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String readUserInput() {
		return SCANNER.nextLine();
	}

}
