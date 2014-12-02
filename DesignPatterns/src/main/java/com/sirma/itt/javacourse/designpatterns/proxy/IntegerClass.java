package com.sirma.itt.javacourse.designpatterns.proxy;

/**
 * The class {@link IntegerClass} contains a method for returning the value of the field.
 */
public class IntegerClass implements IntegerInterface {
	private int sampleValue = 6;

	@Override
	public int getInteger() {
		return sampleValue;
	}

}
