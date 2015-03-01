package com.sirma.itt.javacourse.server;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.javacourse.common.Message;
import com.sirma.itt.javacourse.common.ObjectTransfer;

/**
 * The class {@link ChatServerThreadTest} contains tests for the methods of the classes
 * {@link ObjectTransfer} and {@link ChatServerView}.
 */
@RunWith(MockitoJUnitRunner.class)
public class ChatServerThreadTest {
	@Mock
	private ChatServerView chatServerView;
	private ChatServerModel chatServerModel;
	@Mock
	private ObjectTransfer objectTransfer;

	/**
	 * Sets a chat server model with a mocked parameter.
	 */
	@Before
	public void setUp() {
		chatServerModel = new ChatServerModel(chatServerView);
	}

	/**
	 * Verifies the call to the method writeObject of the class {@link ObjectTransfer}.
	 */
	@Test
	public void testWriteObject() {
		chatServerModel.registerUser(objectTransfer, "abc");
		Mockito.verify(objectTransfer, Mockito.atLeastOnce()).writeObject(
				Mockito.any(Message.class));
		Mockito.verify(chatServerView, Mockito.atLeastOnce()).setInformationAreaContent(
				Mockito.anyString());
	}

}
