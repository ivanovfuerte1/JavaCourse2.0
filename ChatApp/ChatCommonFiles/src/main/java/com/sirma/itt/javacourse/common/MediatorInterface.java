package com.sirma.itt.javacourse.common;

/**
 * The interface {@link MediatorInterface} contains methods for sending messagesto a destination as
 * well as adding a new user to the list of clients.
 */
public interface MediatorInterface {
	/**
	 * Sends messages to the destination.
	 * 
	 * @param msg
	 *            message to send
	 */
	void sendMessage(String msg);

	/**
	 * Adds a new user to the list of clients.
	 * 
	 * @param user
	 *            the new user to add
	 */
	void addUser(User user);
}