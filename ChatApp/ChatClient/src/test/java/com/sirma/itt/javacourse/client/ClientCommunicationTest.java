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
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientCommunicationTest {
	@Mock
	private ClientCommunicationFrame clientCommunicatorFrame;
	@Mock
	private ObjectTransfer objectTransfer;
	private String nickname = "123";
	private ClientCommunicationThread clientCommunicationThread;

	/**
	 * 
	 */
	@Before
	public void setUp() {
		clientCommunicationThread = new ClientCommunicationThread(clientCommunicatorFrame,
				objectTransfer, nickname);
	}

	/**
	 * @throws IOException
	 *             a
	 */
	@Test
	public void test() throws IOException {
		Message message = new Message(nickname, "abc");
		message.setType("textMessage");
		Mockito.when(objectTransfer.readObject()).thenReturn(message);
		Mockito.when(objectTransfer.readObject()).thenThrow(new IOException());
		clientCommunicationThread.run();
		Mockito.verify(clientCommunicatorFrame, Mockito.atLeastOnce()).setOutputFieldContent(
				Mockito.anyString());

	}

	/**
	 * @throws IOException
	 *             a
	 */
	@Test
	public void test2() throws IOException {
		Message message = new Message(nickname, "abc");
		message.setType("newUser");
		Mockito.when(objectTransfer.readObject()).thenReturn(message);
		Mockito.when(objectTransfer.readObject()).thenThrow(new IOException());
		clientCommunicationThread.run();
		Mockito.verify(clientCommunicatorFrame, Mockito.atLeastOnce()).setListOfClientsContent(
				Mockito.anyString());
		Mockito.verify(clientCommunicatorFrame, Mockito.atLeastOnce()).setOutputFieldContent(
				Mockito.anyString());

	}

	/**
	 * @throws IOException
	 *             a
	 */
	@Test
	public void test3() throws IOException {
		Message message = new Message(nickname, "abc");
		message.setType("userList");
		Mockito.when(objectTransfer.readObject()).thenReturn(message);
		Mockito.when(objectTransfer.readObject()).thenThrow(new IOException());
		clientCommunicationThread.run();
		Mockito.verify(clientCommunicatorFrame, Mockito.atLeastOnce()).setOutputFieldContent(
				Mockito.anyString());

	}

	/**
	 * @throws IOException
	 *             a
	 */
	@Test
	public void test4() throws IOException {
		Message message = new Message(nickname, "abc");
		message.setType("userDisconnected");
		Mockito.when(objectTransfer.readObject()).thenReturn(message);
		Mockito.when(objectTransfer.readObject()).thenThrow(new IOException());
		clientCommunicationThread.run();
		Mockito.verify(clientCommunicatorFrame, Mockito.atLeastOnce()).setOutputFieldContent(
				Mockito.anyString());
		Mockito.verify(clientCommunicatorFrame, Mockito.atLeastOnce()).setOutputFieldContent(
				Mockito.anyString());

	}

}
