package com.sirma.itt.javacourse.designpatterns.proxy;

/**
 * The class {@link IntegerFactory} contains methods for creating an instance of the class
 * {@link IntegerProxy} and getting the value of its field.
 */
public class IntegerFactory {
	/**
	 * Creates an instance of the interface {@link IntegerInterface} implemented by the class
	 * {@link IntegerProxy} and assigns the value returned by its method getInteger to the local
	 * field.
	 * 
	 * @return the new instance of IntegerProxy
	 */
	public IntegerInterface createInstance() {
		return new IntegerProxy();
	}
}
