package com.sirma.itt.javacourse.inputoutput.consoletofile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * The class {@link ConsoleToFile} contains methods for reading text from the console and writing it
 * on a text file. Reading stops at a row containing a "." only. The name of the file is specified
 * at the beginning.
 * 
 * @author Svetlosar Kovatchev
 */
public final class ConsoleToFile {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Default constructor.
	 */
	private ConsoleToFile() {
	}

	/**
	 * Sets a value to the reader of the default object.
	 * 
	 * @param input
	 *            the user input
	 */
	public static void setBr(BufferedReader input) {
		ConsoleToFile.br = input;
	}

	/**
	 * Reads a text form the input.
	 * 
	 * @return the text from the input
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static String readText() throws IOException {
		String endOfText = ".";
		StringBuilder sb = new StringBuilder();
		String nameFile;
		try {
			nameFile = br.readLine();
			try (PrintStream fileWriter = new PrintStream(nameFile)) {
				while (true) {
					String row = br.readLine();
					if (row.equals(endOfText)) {
						if (!".".equals(row)) {
							sb.append(row);
						}
						break;
					}
					sb.append(row);
					sb.append("\n");
				}
				fileWriter.print(sb.toString());
				return sb.toString();
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}
}
