package com.sirma.itt.javacourse.inputoutput.consolereader;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.junit.Test;

/**
 * The class {@link ConsoleReaderTest} contains tests for the methods readString, readInteger,
 * readChar and readFloat of the class {@link ConsoleReader}.
 * 
 * @author Svetlosar Kovatchev
 */
public class ConsoleReaderTest {

	/**
	 * Tests the method readString of the class {@link ConsoleReader} with a sample text.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void readString1() throws IOException {
		byte[] byteArray = "sampleText".getBytes();
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
		ConsoleReader.setBr(new InputStreamReader(bais));

		String result = ConsoleReader.readString();
		String expected = "sampleText";
		assertEquals(expected, result);
	}

	/**
	 * Tests the method readString of the class {@link ConsoleReader} with another sample text.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void readString2() throws IOException {
		String toBeTested = "sampleText";
		BufferedReader br = new BufferedReader(new StringReader(toBeTested));
		ConsoleReader.setBr(br);

		String result = ConsoleReader.readString();
		String expected = "sampleText";
		assertEquals(expected, result);
	}

	/**
	 * Tests the method readInteger of the class {@link ConsoleReader} with a sample integer value.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void readInt1() throws IOException {
		String toBeTested = "1024";
		BufferedReader br = new BufferedReader(new StringReader(toBeTested));
		ConsoleReader.setBr(br);

		String result = ConsoleReader.readInt();
		String expected = "1024";
		assertEquals(expected, result);
	}

	/**
	 * Tests the method readFloat of the class {@link ConsoleReader} with a sample floating point
	 * value.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void readFloat1() throws IOException {
		String toBeTested = "10.24";
		BufferedReader br = new BufferedReader(new StringReader(toBeTested));
		ConsoleReader.setBr(br);

		String result = ConsoleReader.readFloat();
		String expected = "10.24";
		assertEquals(expected, result);
	}

	/**
	 * Tests the method readFloat of the class {@link ConsoleReader} with a sample floating point
	 * value.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test(expected = NumberFormatException.class)
	public void readFloat2() throws IOException {
		String toBeTested = "10.2.4";
		BufferedReader br = new BufferedReader(new StringReader(toBeTested));
		ConsoleReader.setBr(br);
		ConsoleReader.readFloat();
	}

	/**
	 * Tests the method readChar of the class {@link ConsoleReader} with a sample character.
	 * 
	 * @throws IOException
	 *             at
	 */
	@Test
	public void readChar1() throws IOException {
		String toBeTested = "a";
		BufferedReader br = new BufferedReader(new StringReader(toBeTested));
		ConsoleReader.setBr(br);

		char result = ConsoleReader.readChar();
		char expected = 'a';
		assertEquals(expected, result);
	}

}
