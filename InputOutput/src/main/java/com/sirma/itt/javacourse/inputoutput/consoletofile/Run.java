package com.sirma.itt.javacourse.inputoutput.consoletofile;

import java.io.IOException;

/**
 * The class Run contains method for testing the method readText of the class {@link ConsoleToFile}
 * from the console.
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
	 * Invokes the user to introduce a name of file and a text in order to write it on a file.
	 * 
	 * @param args
	 *            default arguments
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static void main(String[] args) throws IOException {
		System.out
				.println("Insert name of the file, and after you press enter you can begin typing the text: ");
		System.out.println(ConsoleToFile.readText());
	}
}
