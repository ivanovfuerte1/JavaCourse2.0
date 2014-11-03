package com.sirma.itt.javacourse.inputoutput.consolereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * The class {@link ConsoleReader} contains methods for reading strings, integers, floating point
 * numbers and single characters from an input.
 * 
 * @author Svetlosar Kovatchev
 */
public final class ConsoleReader {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Default constructor.
	 */
	private ConsoleReader() {
	}

	/**
	 * Returns the value from the input.
	 * 
	 * @return the value from the input
	 */
	public static Reader getBr() {
		return br;
	}

	/**
	 * Sets a value as default.
	 * 
	 * @param data
	 *            to be set as default
	 */
	public static void setBr(Reader data) {
		ConsoleReader.br = new BufferedReader(data);
	}

	/**
	 * Reads a string form the input.
	 * 
	 * @return the string from the input
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static String readString() throws IOException {
		return br.readLine();
	}

	/**
	 * Reads a floating point number from the input.
	 * 
	 * @return the integer from the input
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static String readFloat() throws IOException {
		float result = Float.parseFloat(br.readLine());
		return Float.toString(result);
	}

	/**
	 * Reads a single character from the input.
	 * 
	 * @return the character from the input
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static char readChar() throws IOException {
		char result;
		String userInput = br.readLine();
		if (userInput.length() == 1) {
			result = userInput.charAt(0);
		} else {
			throw new IllegalArgumentException("The input contains more than one character!");
		}
		return result;
	}

	/**
	 * Reads an integer from the input.
	 * 
	 * @return the floating point number from the input
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static String readInt() throws IOException {
		int result = Integer.parseInt(br.readLine());
		return Integer.toString(result);
	}

}
