package com.sirma.itt.javacourse.designpatterns.objectpool;

/**
 * The class {@link Reusable} contains a method for creating instances of the class up to the limit
 * set in the class {@link Pool}.
 */
public final class Reusable {

	/**
	 * Constructs an instance of the class.
	 */
	private Reusable() {
	}

	/**
	 * Gets an instance of the class up to the limit set by maxPoolSize of the class {@link Pool}.
	 * 
	 * @return the instance of the class
	 */
	public static Reusable getInstance() {
		return new Reusable();
	}
}
