package com.sirma.itt.javacourse.chat.client;

/**
 * The class {@link MementoChat} contains method for getting the value of its variable.
 */
public class MementoChat {
	private String state;

	/**
	 * Constructs an object assigning a value of its variable.
	 * 
	 * @param state
	 *            the value to assign to the variable of the object
	 */
	public MementoChat(String state) {
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
