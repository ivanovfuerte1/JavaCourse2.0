package com.sirma.itt.javacourse.networking.clientserverconversation;

import static org.junit.Assert.assertTrue;

import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 */
public class DateGeneratorTest {
	private DateGeneratorThread dateGeneratorThread;
	private ClientDateDisplay clientDateDisplay;

	/**
	 * Initializes a client and a server.
	 * 
	 * @throws InterruptedException
	 *             when the thread is interrupted while sleeping
	 */
	@Before
	public void setUp() throws InterruptedException {
		dateGeneratorThread = new DateGeneratorThread(new JTextField());
		dateGeneratorThread.start();
		Thread.sleep(1000);
		clientDateDisplay = new ClientDateDisplay();
	}

	/**
	 * Closes the socket of the server.
	 */
	@After
	public void closeSocket() {
		dateGeneratorThread.stopServer();
	}

	/**
	 * Tests if the content of the text field contains "Hello" after the client is connected.
	 */
	@Test
	public void testTextFieldContent() {
		clientDateDisplay.displayDate();
		assertTrue(clientDateDisplay.getText().contains("Hello"));
	}

	/**
	 * Tests if the content of the text field contains "An" after server is stopped.
	 */
	@Test
	public void test2() {
		dateGeneratorThread.stopServer();
		clientDateDisplay.displayDate();
		assertTrue(clientDateDisplay.getText().contains("An"));
	}

}
