package com.sirma.itt.javacourse.designpatterns.calculator;

import java.io.DataInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link User} contains a method for testing the calculator with input from the console.
 */
public final class User {
	private static final Logger LOGGER = LogManager.getLogger(User.class);
	private static Calculator calculator = new Calculator();

	/**
	 * Default constructor.
	 */
	private User() {
	}

	/**
	 * Tests the calculator with input from the console.
	 * 
	 * @param args
	 *            default arguments
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(System.in);
		StringBuilder stringBuilder = new StringBuilder();
		char ch = '0';
		while (true) {
			byte b = in.readByte();
			ch = (char) b;
			if (ch == '\n' || ch == '\r' || ch == '=') {
				break;
			}
			stringBuilder.append(ch);
		}
		LOGGER.info(calculator.getDetails(stringBuilder.toString()));
	}
}
