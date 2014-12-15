package com.sirma.itt.javacourse.designpatterns.proxy;

/**
 * The class {@link IntegerFactory} contains methods for creating an instance of the class
 * {@link IntegerProxy} and getting the value of its field.
 */
public class IntegerFactory {
	private int testValue;

	/**
	 * Creates an instance of the interface {@link IntegerInterface} implemented by the class
	 * {@link IntegerProxy} and assigns the value returned by its method getInteger to the local
	 * field.
	 * 
	 * XXX: Is this a factory? What do you have to modify here?
	 * 
	 */
	public void createInstance() {
		IntegerInterface integerInterface = new IntegerProxy();
		testValue = integerInterface.getInteger();
	}

	/**
	 * Gets the value of the field.
	 * 
	 * @return the value of the field
	 */
	public int getTestValue() {
		return testValue;
	}
}
