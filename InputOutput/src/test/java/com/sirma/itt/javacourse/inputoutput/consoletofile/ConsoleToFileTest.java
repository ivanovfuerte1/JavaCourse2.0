package com.sirma.itt.javacourse.inputoutput.consoletofile;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
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

	/**
	 * Tests the method readText of the class {@link ConsoleToFile} with a sample text.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void testReadText() throws IOException {
		final String toBeTested = "Name of file.txt\nThis is the\ntext in the file.\n.\n";
		BufferedReader br = new BufferedReader(new StringReader(toBeTested));
		ConsoleToFile.setBr(br);

		String result = ConsoleToFile.readText();
		String expected = "This is the\ntext in the file.\n";
		assertEquals(expected, result);
	}

}
