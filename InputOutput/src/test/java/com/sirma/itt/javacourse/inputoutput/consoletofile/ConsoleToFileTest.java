package com.sirma.itt.javacourse.inputoutput.consoletofile;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

/**
 * The class {@link ConsoleToFileTest} contains tests for the methods of the class
 * {@link ConsoleToFile}.
 * 
 * @author Svetlosar Kovatchev
 */
public class ConsoleToFileTest {
	private static final String END_LINE = System.lineSeparator();

	/**
	 * Tests the method readText of the class {@link ConsoleToFile} with an invalid for name of file
	 * character.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test(expected = IOException.class)
	public void testInvalidFileName() throws IOException {
		final String toBeTested = "\"" + END_LINE + "This is the" + END_LINE + "text in the file."
				+ END_LINE + "." + END_LINE;
		BufferedReader br = new BufferedReader(new StringReader(toBeTested));
		ConsoleToFile.setBr(br);

		String result = ConsoleToFile.readText();
		String expected = "This is the" + END_LINE + "text in the file." + END_LINE;
		assertEquals(expected, result);
	}

	/**
	 * Tests the method readText of the class {@link ConsoleToFile} with a sample text.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void readCorrectData() throws IOException {
		final String toBeTested = "Name of file.txt" + END_LINE + "This is the" + END_LINE
				+ "text in the file." + END_LINE + "." + END_LINE;
		BufferedReader br = new BufferedReader(new StringReader(toBeTested));
		ConsoleToFile.setBr(br);

		String result = ConsoleToFile.readText();
		String expected = "This is the" + END_LINE + "text in the file." + END_LINE;
		File file = new File("Name of file.txt");
		file.delete();
		assertEquals(expected, result);
	}

	/**
	 * Tests the method readText of the class {@link ConsoleToFile} with a name of file that already
	 * exists.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExistingFileName() throws IOException {
		final String toBeTested = "src/test/resources/characteroutput.txt" + END_LINE
				+ "This is the" + END_LINE + "text in the file." + END_LINE + "." + END_LINE;
		BufferedReader br = new BufferedReader(new StringReader(toBeTested));
		ConsoleToFile.setBr(br);

		String result = ConsoleToFile.readText();
		String expected = "This is the" + END_LINE + "text in the file." + END_LINE;
		assertEquals(expected, result);
	}

}
