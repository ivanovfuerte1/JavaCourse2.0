package com.sirma.itt.javacourse.server;

import java.io.IOException;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link UserTest} contains tests for the methods of the class {@link ChatServerModel}.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserTest {
	@Mock
	private ObjectTransfer objectTransfer;
	@Mock
	private ChatServerModel chatServerModel;
	@Mock
	private Map<String, ObjectTransfer> clients;
	private User user;

	/**
	 * Sets a User with mocked parameters.
	 */
	@Before
	public void setUp() {
		user = new User(objectTransfer, chatServerModel, clients);
	}

	/**
	 * Verifies the call to the methods unregisterUser and remove of the classes
	 * {@link ChatServerModel} and the map of clients.
	 * 
	 * @throws IOException
	 *             if an input-output operation is failed or interrupted
	 */
	@Test
	public void testCommunicateException() throws IOException {
		Mockito.when(objectTransfer.readObject()).thenThrow(new IOException());
		user.communicate();
		Mockito.verify(chatServerModel, Mockito.atLeastOnce()).unregisterUser(
				Mockito.any(ObjectTransfer.class), Mockito.anyString());
		Mockito.verify(clients, Mockito.atLeastOnce()).remove(Mockito.anyString());
	}

	/**
	 * Verifies the call to the method keySet of the map of clients.
	 * 
	 * @throws IOException
	 *             if an input-output operation is failed or interrupted
	 */
	@Test
	public void testRun() throws IOException {
		Mockito.when(objectTransfer.readObject()).thenReturn(new Message().attachNickname("abc"))
				.thenThrow(new IOException());
		user.run();
		Mockito.verify(clients, Mockito.atLeastOnce()).keySet();
	}
}
