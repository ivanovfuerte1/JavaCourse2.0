package com.sirma.itt.javacourse.client;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ClientCommunicationTest} contains tests for the methods of the class
 * {@link ClientCommunicationView}.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientCommunicationTest {
	@Mock
	private ClientCommunicationView clientCommunicatorView;
	@Mock
	private ObjectTransfer objectTransfer;
	private String nickname = "123";
	private ClientCommunicationModel clientCommunicationModel;

	/**
	 * Sets a client communication model with mocked parameters and a sample nickname.
	 */
	@Before
	public void setUp() {
		clientCommunicationModel = new ClientCommunicationModel(clientCommunicatorView,
				objectTransfer, nickname);
	}

	/**
	 * Verifies the call to the method setOutputMessageAreaContent of the class
	 * {@link ClientCommunicationView} for a message of type "textMessage".
	 * 
	 * @throws IOException
	 *             if an input-output operation is failed or interrupted
	 */
	@Test
	public void testTextMessage() throws IOException {
		Message message = new Message().attachNickname(nickname).attachContents("abc");
		message.setType("textMessage");
		Mockito.when(objectTransfer.readObject()).thenReturn(message);
		Mockito.when(objectTransfer.readObject()).thenThrow(new IOException());
		clientCommunicationModel.run();
		Mockito.verify(clientCommunicatorView, Mockito.atLeastOnce()).setOutputMessageAreaContent(
				Mockito.anyString());

	}

	/**
	 * Verifies the call to the methods setListOfClientsContent and setOutputMessageAreaContent for
	 * a message of type "newUser".
	 * 
	 * @throws IOException
	 *             if an input-output operation is failed or interrupted
	 */
	@Test
	public void testNewUser() throws IOException {
		Message message = new Message().attachNickname(nickname).attachContents("abc");
		message.setType("newUser");
		Mockito.when(objectTransfer.readObject()).thenReturn(message);
		Mockito.when(objectTransfer.readObject()).thenThrow(new IOException());
		clientCommunicationModel.run();
		Mockito.verify(clientCommunicatorView, Mockito.atLeastOnce()).setListOfClientsContent(
				Mockito.anyString());
		Mockito.verify(clientCommunicatorView, Mockito.atLeastOnce()).setOutputMessageAreaContent(
				Mockito.anyString());

	}

	/**
	 * Verifies the call to the method setOutputMessageAreaContent of the class
	 * {@link ClientCommunicationView} for a message of type "userList".
	 * 
	 * @throws IOException
	 *             if an input-output operation is failed or interrupted
	 */
	@Test
	public void testUserList() throws IOException {
		Message message = new Message().attachNickname(nickname).attachContents("abc");
		message.setType("userList");
		Mockito.when(objectTransfer.readObject()).thenReturn(message);
		Mockito.when(objectTransfer.readObject()).thenThrow(new IOException());
		clientCommunicationModel.run();
		Mockito.verify(clientCommunicatorView, Mockito.atLeastOnce()).setOutputMessageAreaContent(
				Mockito.anyString());

	}

	/**
	 * Verifies the call to the method setOutputMessageAreaContent of the class
	 * {@link ClientCommunicationView} for a message of type "userDisconnected".
	 * 
	 * @throws IOException
	 *             if an input-output operation is failed or interrupted
	 */
	@Test
	public void testUserDisconnected() throws IOException {
		Message message = new Message().attachNickname(nickname).attachContents("abc");
		message.setType("userDisconnected");
		Mockito.when(objectTransfer.readObject()).thenReturn(message);
		Mockito.when(objectTransfer.readObject()).thenThrow(new IOException());
		clientCommunicationModel.run();
		Mockito.verify(clientCommunicatorView, Mockito.atLeastOnce()).setOutputMessageAreaContent(
				Mockito.anyString());
		Mockito.verify(clientCommunicatorView, Mockito.atLeastOnce()).setListOfClientsContent(
				Mockito.anyString());

	}

}
