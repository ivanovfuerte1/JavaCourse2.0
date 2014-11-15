package com.sirma.itt.javacourse.inputoutput.reversefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The class {@link ReverseFile} contains a method for reversing the content of a text file. The new
 * content replaces the old one.
 * 
 * @author Svetlosar Kovatchev
 */
public final class ReverseFile {
	private static final String END_LINE = System.lineSeparator();

	/**
	 * Default constructor.
	 */
	private ReverseFile() {
	}

	/**
	 * Reverses the content of a file.
	 * 
	 * @param nameFile
	 *            the name of the file
	 * @return the reversed text
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static String reverseFile(String nameFile) throws IOException {
		File fileCheck = new File(nameFile);
		if (!fileCheck.isFile()) {
			throw new IllegalArgumentException("The input contains invalid characters!");
		}
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		String l;
		StringBuilder sb = new StringBuilder();
		try {
			inputStream = new BufferedReader(new FileReader(nameFile));
			while ((l = inputStream.readLine()) != null) {
				sb.append(l);
				sb.append(END_LINE);
				sb.deleteCharAt(sb.length() - 2);
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.reverse();
			outputStream = new PrintWriter(new FileWriter(nameFile));
			outputStream.println(sb);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
		return sb.toString();
	}
}
