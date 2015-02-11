package com.sirma.itt.javacourse.common;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link Mediator} contains methods for sending messages to all connected clients as well
 * as adding a new user to the list of clients.
 */
public class Mediator implements MediatorInterface {

	private static List<User> users;

	/**
	 * Getter method for users.
	 *
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * Setter method for users.
	 *
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<User> users) {
		Mediator.users = users;
	}

	/**
	 * Constructs an implementation of {@link Mediator} initializing its list of users.
	 */
	public Mediator() {
		Mediator.users = new ArrayList<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void sendMessage(String message) {
		for (User currentUser : Mediator.users) {
			currentUser.receive(message);
			System.out.println(currentUser.getNickname() + " is in the list of users.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addUser(User user) {
		Mediator.users.add(user);
		System.out.println(user.getNickname() + " is added.");
	}

}