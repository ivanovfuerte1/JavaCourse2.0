package com.sirma.itt.javacourse.inputoutput.consoletofile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link ConsoleToFile} contains methods for reading text from the console and writing it
 * on a text file. Reading stops at a row containing a "." only. The name of the file is specified
 * at the beginning.
 * 
 * @author Svetlosar Kovatchev
 */
public final class ConsoleToFile {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final String END_OF_FILE = ".";
	private static File file;
	private static final String END_LINE = System.lineSeparator();
	private static final Logger LOGGER = LogManager.getLogger(ConsoleToFile.class);

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
	 * Reads a text form the input. If the file already exists its contents will be replaced.
	 * 
	 * @return the text from the input
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static String readText() throws IOException {
		String endOfText = END_OF_FILE;
		StringBuilder sb = new StringBuilder();
		String nameFile;
		try {
			nameFile = br.readLine();
			try {
				file = new File(nameFile);
				if (file.createNewFile()) {
					LOGGER.info("File is created.");
				} else {
					LOGGER.info("File exists.");
					throw new IllegalArgumentException();
				}
			} catch (IOException e) {
				LOGGER.info("File name contains illegal characters.");
			}
			try (PrintStream fileWriter = new PrintStream(nameFile)) {
				while (true) {
					nameFile = br.readLine();
					if (nameFile.equals(endOfText)) {
						if (!END_OF_FILE.equals(nameFile)) {
							sb.append(nameFile);
						}
						break;
					}
					sb.append(nameFile);
					sb.append(END_LINE);
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
