package com.sirma.itt.javacourse.common;

/**
 * The class {@link User} contains methods sending and receiving messages.
 */
public abstract class User {
	private MediatorInterface mediatorInterface;
	private String nickname;

	/**
	 * Construct a new user object assigning to its variables values for mediator and nickname.
	 * 
	 * @param mediatorInterface
	 *            the mediator for communication
	 * @param nickname
	 *            the nickname of the user
	 */
	public User(MediatorInterface mediatorInterface, String nickname) {
		this.setMediatorInterface(mediatorInterface);
		this.setNickname(nickname);
	}

	/**
	 * Sends message to other users.
	 * 
	 * @param message
	 *            the message to send
	 */
	public abstract void send(String message);

	/**
	 * Receives message from other user.
	 * 
	 * @param message
	 *            the message to receive
	 */
	public abstract void receive(String message);

	/**
	 * Returns the mediatorInterface of the current client.
	 * 
	 * @return the midiatorInterface of the current client
	 */
	public MediatorInterface getMediatorInterface() {
		return mediatorInterface;
	}

	/**
	 * Sets a new mediatorInterface for the current client.
	 * 
	 * @param mediatorInterface
	 *            the new mediatorInterface to assign
	 */
	public void setMediatorInterface(MediatorInterface mediatorInterface) {
		this.mediatorInterface = mediatorInterface;
	}

	/**
	 * Returns the nickname of the user.
	 * 
	 * @return the nickname of the user
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Sets a new nickname for the user.
	 * 
	 * @param nickname
	 *            the new nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
