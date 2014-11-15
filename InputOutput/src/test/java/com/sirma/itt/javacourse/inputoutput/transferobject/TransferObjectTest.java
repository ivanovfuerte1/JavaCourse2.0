package com.sirma.itt.javacourse.inputoutput.transferobject;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * The class {@link TransferObjectTest} contains tests for the method transfer of the class
 * {@link TransferObject}.
 * 
 * @author Svetlosar Kovatchev
 */
public class TransferObjectTest {
	private static final String TEST_FILE = "src\\test\\resources\\Name of file.txt";
	private static final String OUTPUT_FILE = "src\\test\\resources\\characteroutput.txt";

	/**
	 * Tests the method transfer of the class {@link TransferObject} with sample values for bytes to
	 * be transferred and offset from the beginning of the input stream.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void test() throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		int result = 0;
		try {
			inputStream = new FileInputStream(TEST_FILE);
			outputStream = new FileOutputStream(OUTPUT_FILE);
			TransferObject transferObject = new TransferObject(inputStream, outputStream);
			result = transferObject.transfer(10, 0);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
		int expected = 10;
		assertEquals(expected, result);
	}

	/**
	 * Tests the method transfer of the class {@link TransferObject} with another sample values for
	 * bytes to be transferred and offset from the beginning of the input stream.
	 *
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void test2() throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		int result = 0;
		try {
			inputStream = new FileInputStream(TEST_FILE);
			outputStream = new FileOutputStream(OUTPUT_FILE);
			TransferObject transferObject = new TransferObject(inputStream, outputStream);
			result = transferObject.transfer(50, 10);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
		int expected = 21;
		assertEquals(expected, result);
	}

	/**
	 * Tests the method transfer of the class {@link TransferObject} with another sample values for
	 * bytes to be transferred and offset from the beginning of the input stream.
	 *
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void test3() throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		int result = 0;
		try {
			inputStream = new FileInputStream(TEST_FILE);
			outputStream = new FileOutputStream(OUTPUT_FILE);
			TransferObject transferObject = new TransferObject(inputStream, outputStream);
			result = transferObject.transfer(3, 2);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
		int expected = 3;
		assertEquals(expected, result);
	}

	/**
	 * Tests the method transfer of the class {@link TransferObject} with another sample values for
	 * bytes to be transferred and offset from the beginning of the input stream.
	 *
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test
	public void test4() throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		int result = 0;
		try {
			inputStream = new FileInputStream(TEST_FILE);
			outputStream = new FileOutputStream(OUTPUT_FILE);
			TransferObject transferObject = new TransferObject(inputStream, outputStream);
			result = transferObject.transfer(5, 28);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
		int expected = 3;
		assertEquals(expected, result);
	}

}
