package com.sirma.itt.javacourse.collections.exceptionsmanager;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

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
	// XXX: describe this!
	private boolean subsequentMessage = false;
	// XXX: var name
	private StringBuilder sb = new StringBuilder();

	/**
	 * Constructs an object of the {@link ExceptionsManager} containing predefined messages.
	 * 
	 * XXX: you have to provide a pre-defined set of exception messages!
	 * 
	 * @param allPermittedMessages
	 *            a XXX: describe the variable
	 */
	public ExceptionsManager(String[] allPermittedMessages) {
		for (int i = 0; i < allPermittedMessages.length; i++) {
			String key = Integer.toString(i);
			this.exceptions.put(key, allPermittedMessages[i]);
		}
	}

	/**
	 * Adds a new message to the to the combination of messages for output.
	 * 
	 * XXX: rename var name
	 * @param mess
	 *            the message to add
	 */
	public void addExceptionMessage(String mess) {
		if (exceptions.containsValue(mess)) {
			if (subsequentMessage) {
				sb.append(SEPARATOR);
			} else {
				// XXX: ??
				subsequentMessage = true;
			}
			sb.append(mess);
			this.message = sb.toString();
		} else {
			// XXX: You could define a custom exception here
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Adds a new message according to its message code to the combination of messages for output.
	 * 
	 * @param messageCode
	 *            the code of the message to add
	 */
	public void addExceptionMessageUsingCode(String messageCode) {
		// XXX: duplicated method
		if (exceptions.containsKey(messageCode)) {
			if (subsequentMessage) {
				sb.append(SEPARATOR);
			} else {
				subsequentMessage = true;
			}
			sb.append(exceptions.get(messageCode));
			this.message = sb.toString();
		} else {
			// XXX: You could define a custom exception here
			throw new IllegalArgumentException();
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
