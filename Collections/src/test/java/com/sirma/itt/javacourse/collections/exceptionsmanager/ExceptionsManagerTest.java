package com.sirma.itt.javacourse.collections.exceptionsmanager;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link ExceptionsManagerTest} contains methods for testing the methods of the class
 * {@link ExceptionsManager}.
 * 
 * @author Svetlosar Kovatchev
 */
public class ExceptionsManagerTest {

	private PermittedMessages[] allPermittedMessages = { PermittedMessages.FIRST_MESSAGE,
			PermittedMessages.SECOND_MESSAGE, PermittedMessages.THIRD_MESSAGE };

	/**
	 * Tests the generated string after adding several messages by code.
	 * 
	 * @throws UndefinedMessage
	 *             when the message is not defined
	 */
	@Test
	public void testCorrectCode() throws UndefinedMessage {
		ExceptionsManager exceptionManager = new ExceptionsManager(allPermittedMessages);
		System.out.println(PermittedMessages.FIRST_MESSAGE.toString());
		exceptionManager.addExceptionMessageUsingCode(PermittedMessages.THIRD_MESSAGE.toString());
		exceptionManager.addExceptionMessageUsingCode(PermittedMessages.SECOND_MESSAGE.toString());
		assertEquals("Zip code invalid|Invalid debit card number", exceptionManager.getMessage());
	}

	/**
	 * Tests the generated string after adding several messages.
	 *
	 * @throws UndefinedMessage
	 *             when the message is not defined
	 */
	@Test
	public void testCorrectMessages() throws UndefinedMessage {
		ExceptionsManager exceptionManager = new ExceptionsManager(allPermittedMessages);
		exceptionManager.addExceptionMessage(PermittedMessages.FIRST_MESSAGE.getMessage());
		exceptionManager.addExceptionMessage(PermittedMessages.SECOND_MESSAGE.getMessage());
		assertEquals("Wrong ID|Invalid debit card number", exceptionManager.getMessage());
	}

	/**
	 * Tests the method addExceptionMessageUsingCode with non-existing code of message.
	 *
	 * @throws UndefinedMessage
	 *             when the message is not defined
	 */
	@Test(expected = UndefinedMessage.class)
	public void testWrongCode() throws UndefinedMessage {
		ExceptionsManager exceptionManager = new ExceptionsManager(allPermittedMessages);
		exceptionManager.addExceptionMessage(PermittedMessages.FIRST_MESSAGE.getMessage());
		exceptionManager.addExceptionMessage(PermittedMessages.SECOND_MESSAGE.getMessage());
		exceptionManager.addExceptionMessageUsingCode(PermittedMessages.SECOND_MESSAGE.toString());
		exceptionManager.addExceptionMessageUsingCode("Non-existent code");
	}

	/**
	 * Tests the method addExceptionMessage with non-existing message.
	 *
	 * @throws UndefinedMessage
	 *             when the message is not defined
	 */
	@Test(expected = UndefinedMessage.class)
	public void testWrongMessage() throws UndefinedMessage {
		ExceptionsManager exceptionManager = new ExceptionsManager(allPermittedMessages);
		exceptionManager.addExceptionMessage(PermittedMessages.FIRST_MESSAGE.getMessage());
		exceptionManager.addExceptionMessage("Inexistent message");
	}
}
