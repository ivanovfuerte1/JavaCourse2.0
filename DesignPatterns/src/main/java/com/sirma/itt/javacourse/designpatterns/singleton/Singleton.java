package com.sirma.itt.javacourse.designpatterns.singleton;

/**
 * The class {@link Singleton} contains methods for instantiating a single instance of it, and for
 * counting the number of instances.
 */
public final class Singleton {
	private static final Singleton SINGLE_INSTANCE = new Singleton();

	/**
	 * Constructs instance of the class.
	 */
	private Singleton() {
	}

	/**
	 * Gets the instance of the class.
	 * 
	 * @return the instance of the class
	 */
	public static Singleton getSingleInstance() {
		return SINGLE_INSTANCE;
	}
}
