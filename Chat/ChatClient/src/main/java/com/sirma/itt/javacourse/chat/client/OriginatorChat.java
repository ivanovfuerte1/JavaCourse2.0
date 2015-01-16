package com.sirma.itt.javacourse.chat.client;

/**
 * The class {@link OriginatorChat} contains methods for saving its variable in container class and
 * assigning it the value of a container class.
 */
public class OriginatorChat {
	private String state;

	/**
	 * Sets the current state of the message.
	 * 
	 * @param state
	 *            the state of the message
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Returns the state of the message.
	 * 
	 * @return the state of the message
	 */
	public String getState() {
		return state;
	}

	/**
	 * Saves the state to a container class.
	 * 
	 * @return the state into a container class
	 */
	public MementoChat saveStateToMemento() {
		return new MementoChat(state);
	}

	/**
	 * Assigns to the message variable the value of certain container class.
	 * 
	 * @param mementoChat
	 *            the container class to get the value from
	 */
	public void getStateFromMemento(MementoChat mementoChat) {
		state = mementoChat.getState();
	}
}
