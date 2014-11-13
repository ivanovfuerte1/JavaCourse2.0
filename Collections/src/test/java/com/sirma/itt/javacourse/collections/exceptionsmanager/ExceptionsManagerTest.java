package com.sirma.itt.javacourse.collections.exceptionsmanager;

import org.junit.Test;

/**
 * The class {@link ExceptionsManagerTest} contains methods for testing the methods of the class
 * {@link ExceptionsManager}.
 * 
 * @author Svetlosar Kovatchev
 */
public class ExceptionsManagerTest {
	private String[] allPermittedMessages = new String[] { "Wrong ID", "Invalid debit card number",
			"Zip code invalid" };

	/**
	 * Tests the method addExceptionMessageUsingCode with non-existing code of message.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWrongCode() {
		ExceptionsManager exceptionManager = new ExceptionsManager(allPermittedMessages);
		exceptionManager.addExceptionMessage("Wrong ID");
		exceptionManager.addExceptionMessage("Invalid debit card number");
		exceptionManager.addExceptionMessageUsingCode("2");
		exceptionManager.addExceptionMessageUsingCode("3");
	}

	/**
	 * Tests the method addExceptionMessage with non-existing message.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testWrongMessage() {
		ExceptionsManager exceptionManager = new ExceptionsManager(allPermittedMessages);
		exceptionManager.addExceptionMessage("Wrong ID");
		exceptionManager.addExceptionMessage("Inexistent message");
	}

}
