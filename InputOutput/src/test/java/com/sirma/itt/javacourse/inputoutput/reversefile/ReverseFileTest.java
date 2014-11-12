package com.sirma.itt.javacourse.inputoutput.reversefile;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * The class {@link ReverseFileTest} contains a method for testing the method of the class
 * {@link ReverseFile}.
 * 
 * @author Svetlosar Kovatchev
 */
public class ReverseFileTest {
	private static final String END_LINE = System.lineSeparator();

	/**
	 * Tests the method reverseFile of the class {@link ReverseFile} with sample file. The file is
	 * reversed twice in order to check if it contains the original data.
	 *
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void testDobleReversedFile() throws IOException {
		// XXX: where are those files?
		String fileName = "Name of file.txt";
		for (int i = 0; i < 2; i++) {
			ReverseFile.reverseFile(fileName);
		}
		StringBuilder sb = new StringBuilder();
		String l;
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(fileName));
			while ((l = inputStream.readLine()) != null) {
				sb.append(l);
				sb.append(END_LINE);
				sb.deleteCharAt(sb.length() - 2);
			}
			sb.deleteCharAt(sb.length() - 1);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		String result = sb.toString();
		String expected = "This is the" + "\n" + "text in the file.";
		assertEquals(result, expected);
	}

	/**
	 * Tests the method reverseFile of the class {@link ReverseFile} with sample file. The file is
	 * reversed and compared with its reversed content.
	 *
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void testReversedFile() throws IOException {
		String fileName = "Name of file.txt";
		String result = ReverseFile.reverseFile(fileName);
		String expected = ".elif eht ni txet" + "\n" + "eht si sihT";
		assertEquals(expected, result);
	}

}
