package com.sirma.itt.javacourse.designpatterns.proxy;

/**
 * The class {@link ClientProxy} contains methods for testing the method create instance of the
 * class {@link IntegerFactory}.
 * 
 * XXX: if it's runner name it so
 */
public final class ClientProxy {
	/**
	 * Default constructor.
	 */
	private ClientProxy() {
	}

	/**
	 * Tests the method create instance of the class {@link IntegerFactory}.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		IntegerFactory integerFactory = new IntegerFactory();
		integerFactory.createInstance();
	}
}
