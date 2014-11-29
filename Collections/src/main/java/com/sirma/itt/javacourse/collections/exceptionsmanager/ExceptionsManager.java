package com.sirma.itt.javacourse.collections.exceptionsmanager;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link ExceptionsManager} contains methods for setting a combination of predefined list
 * of exception messages in a simple string.
 * 
 * @author Svetlosar Kovatchev
 */
public class ExceptionsManager {
	private Map<String, String> exceptions = new HashMap<>();
	private String message = "";
	private static final String SEPARATOR = "|";
	private boolean firstMessage = true;
	private StringBuilder stringBuilder = new StringBuilder();
	private static final Logger LOGGER = LogManager.getLogger(ExceptionsManager.class);

	/**
	 * Constructs an object of the {@link ExceptionsManager} containing predefined messages.
	 * 
	 * @param allPermittedMessages
	 *            provides a set of predefined exception messages
	 */
	public ExceptionsManager(PermittedMessages[] allPermittedMessages) {
		for (int i = 0; i < allPermittedMessages.length; i++) {
			String key = allPermittedMessages[i].toString();
			this.exceptions.put(key, allPermittedMessages[i].getMessage());
		}
	}

	/**
	 * Adds a new message to the to the combination of messages for output.
	 * 
	 * @param newMessage
	 *            the message to add
	 * @throws UndefinedMessage
	 *             when the message is not defined
	 */
	public void addExceptionMessage(String newMessage) throws UndefinedMessage {
		if (exceptions.containsValue(newMessage)) {
			if (!firstMessage) {
				stringBuilder.append(SEPARATOR);
			} else {
				firstMessage = false;
			}
			this.message = stringBuilder.append(newMessage).toString();
		} else {
			LOGGER.error("The message is not defined");
			throw new UndefinedMessage("The message is not defined", null);
		}
	}

	/**
	 * Adds a new message according to its message code to the combination of messages for output.
	 * 
	 * @param messageCode
	 *            the code of the message to add
	 * @throws UndefinedMessage
	 *             when the message is not defined
	 */
	public void addExceptionMessageUsingCode(String messageCode) throws UndefinedMessage {
		if (exceptions.containsKey(messageCode)) {
			if (!firstMessage) {
				stringBuilder.append(SEPARATOR);
			} else {
				firstMessage = false;
			}
			this.message = stringBuilder.append(exceptions.get(messageCode)).toString();
		} else {
			LOGGER.error("The message code is not defined");
			throw new UndefinedMessage("The message code is not defined", null);
		}
	}

	/**
	 * Returns a string containing the messages.
	 * 
	 * @return all messages as a string
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Converts the string of exception messages to a collection of strings.
	 * 
	 * @param messagesCombinaton
	 *            the string containing messages
	 * @return a collection of strings containing messages
	 */
	public Collection<String> getMessages(String messagesCombinaton) {
		String[] messages = messagesCombinaton.split(Pattern.quote(SEPARATOR));
		return Arrays.asList(messages);
	}

}
