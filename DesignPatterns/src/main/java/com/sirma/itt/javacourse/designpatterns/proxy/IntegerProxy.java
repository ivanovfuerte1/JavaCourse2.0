package com.sirma.itt.javacourse.designpatterns.proxy;

/**
 * The class {@link IntegerProxy} contains a method for returning the value of the field of the
 * class {@link IntegerClass}.
 */
public class IntegerProxy implements IntegerInterface {
	private IntegerClass integerClass;

	@Override
	public int getInteger() {
		if (integerClass == null) {
			integerClass = new IntegerClass();
		}
		return integerClass.getInteger();
	}

}
