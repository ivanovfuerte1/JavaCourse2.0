package com.sirma.itt.javacourse.designpatterns.singleton;

/**
 * The class {@link Singleton} contains methods for instantiating a single instance of it, and for
 * counting the number of instances.
 */
public final class Singleton {
	private static final Singleton SINGLE_INSTANCE = new Singleton();
	// XXX: Why do we need this?
	private int instances = 0;

	/**
	 * Constructs instance of the class.
	 */
	private Singleton() {
		instances++;
	}

	/**
	 * XXX: Thread safety!
	 * 
	 * Gets the instance of the class.
	 * 
	 * @return the instance of the class
	 */
	public static Singleton getSingleInstance() {
		return SINGLE_INSTANCE;
	}

	/**
	 * Gets the number of instances created.
	 * 
	 * @return the current number of instances
	 */
	public int numberOfInstances() {
		return instances;
	}
}
