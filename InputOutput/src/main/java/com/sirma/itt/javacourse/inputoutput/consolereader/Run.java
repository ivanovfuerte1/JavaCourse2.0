package com.sirma.itt.javacourse.inputoutput.consolereader;

import java.io.IOException;

/**
 * The class Run contains method for testing the methods readString, readInteger, readChar and
 * readFloat of the class {@link ConsoleReader} from the console.
 * 
 * @author Svetlosar Kovatchev
 */
public final class Run {
	/**
	 * Default constructor.
	 */
	private Run() {
	}

	/**
	 * Invokes the user to introduce a value for each of the corresponding methods readString,
	 * readInteger, readChar and readFloat of the class {@link ConsoleReader} from the console.
	 * 
	 * @param args
	 *            default arguments
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Write something: ");
		System.out.println(ConsoleReader.readString());
		System.out.println("Write a float value: ");
		System.out.println(ConsoleReader.readFloat());
		System.out.println("Write a character: ");
		System.out.println(ConsoleReader.readChar());
		System.out.println("Write an integer value: ");
		System.out.println(ConsoleReader.readInt());
	}
}
