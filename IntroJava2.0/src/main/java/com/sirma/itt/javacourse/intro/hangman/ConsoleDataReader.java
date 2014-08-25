package com.sirma.itt.javacourse.intro.hangman;

import java.util.Scanner;

/**
 * The class ConsoleDataReader contains a method for reading a line from the console.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class ConsoleDataReader implements DataReader {
	private Scanner scanner = new Scanner(System.in);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String readString() {
		System.out.println("Enter the whole word or press ENTER");
		return scanner.nextLine();
	}

}
