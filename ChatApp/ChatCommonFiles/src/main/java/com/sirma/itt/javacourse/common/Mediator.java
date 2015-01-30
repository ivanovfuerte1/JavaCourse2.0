package com.sirma.itt.javacourse.common;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link Mediator} contains methods for sending messages to all connected clients as well
 * as adding a new user to the list of clients.
 */
public class Mediator implements MediatorInterface {

	private List<User> users;

	/**
	 * Constructs an implementation of {@link Mediator} initializing its list of users.
	 */
	public Mediator() {
		this.users = new ArrayList<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sendMessage(String message) {
		for (User currentUser : this.users) {
			currentUser.receive(message);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addUser(User user) {
		this.users.add(user);

	}

}