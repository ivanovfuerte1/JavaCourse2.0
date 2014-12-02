package com.sirma.itt.javacourse.designpatterns.abstractfactory;

/**
 * The class {@link MyClass} contains method for selecting a factory for creating or resizing a
 * figure.
 */
public final class MyClass {
	private static final String SHAPE = "Shape";

	/**
	 * Default constructor.
	 */
	private MyClass() {
	}

	/**
	 * Selects a factory for creating or resizing a figure.
	 * 
	 * @param choice
	 *            one of the possible choices - to create or resize a figure
	 * @return the factory to do the job - creating or resizing
	 */
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase(SHAPE)) {
			return new ShapeFactory();
		}
		return new SizeFactory();
	}
}
