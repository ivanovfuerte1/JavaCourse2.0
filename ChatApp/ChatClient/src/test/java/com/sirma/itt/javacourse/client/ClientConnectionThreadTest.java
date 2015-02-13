package com.sirma.itt.javacourse.client;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * The class {@link ClientConnectionThreadTest} contains tests for the class
 * {@link ClientConnectionThread}.
 */
public class ClientConnectionThreadTest {

	@Mock
	private ClientConnectionFrame clinetConnectionFrame;
	private ClientConnectionThread clientConnectionThread;
	private String nickname = "abc";

	/**
	 * Sets the client connection thread with mocked and sample arguments.
	 */
	@Before
	public void setUp() {
		clientConnectionThread = new ClientConnectionThread(clinetConnectionFrame);
	}

	/**
	 * Tests the method getNickname of the class {@link ClientConnectionThread}.
	 */
	@Test
	public void testGetNickname() {
		clientConnectionThread.setNickname(nickname);
		String expected = nickname;
		String actual = clientConnectionThread.getNickname();
		assertEquals(expected, actual);
	}

	/**
	 * Tests the method setNickname of the class {@link ClientConnectionThread}.
	 */
	@Test
	public void testSetNickname() {
		String newNickname = "def";
		clientConnectionThread.setNickname(newNickname);
		String expected = newNickname;
		String actual = clientConnectionThread.getNickname();
		assertEquals(expected, actual);
	}

}
