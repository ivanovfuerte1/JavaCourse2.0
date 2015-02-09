package com.sirma.itt.javacourse.networking.reversingmessages;

/**
 * The class {@link Memento} contains a method for getting the value of its variable.
 */
public class Memento {
	private String state;

	/**
	 * Constructs an object assigning a value of its variable.
	 * 
	 * @param state
	 *            the value to assign to the variable of the object
	 */
	public Memento(String state) {
		this.state = state;
	}

	/**
	 * Returns the state of its variable.
	 * 
	 * @return the state of its variable
	 */
	public String getState() {
		return state;
	}
}
