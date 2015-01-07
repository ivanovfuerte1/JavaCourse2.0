package com.sirma.itt.javacourse.networking.reversingmessages;

/**
 * The class {@link Originator} contains methods for saving its variable in container class and
 * assigning it the value of a container class.
 */
public class Originator {
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
	public Memento saveStateToMemento() {
		return new Memento(state);
	}

	/**
	 * Assigns to the message variable the value of certain container class.
	 * 
	 * @param memento
	 *            the container class to get the value from
	 */
	public void getStateFromMemento(Memento memento) {
		state = memento.getState();
	}
}
