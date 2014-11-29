package com.sirma.itt.javacourse.collections.exceptionsmanager;

/**
 * The enumeration {@link PermittedMessages} maps messages with constants.
 */
public enum PermittedMessages {
	FIRST_MESSAGE("Wrong ID"), SECOND_MESSAGE("Invalid debit card number"), THIRD_MESSAGE(
			"Zip code invalid");
	private String message;

	/**
	 * Constructs enumeration assigning a message to its variable.
	 * 
	 * @param message
	 *            the current message
	 */
	private PermittedMessages(String message) {
		this.message = message;
	}

	/**
	 * Gets the message associated with the enumeration.
	 * 
	 * @return the message associated with the enumeration
	 */
	public String getMessage() {
		return message;
	}
}
