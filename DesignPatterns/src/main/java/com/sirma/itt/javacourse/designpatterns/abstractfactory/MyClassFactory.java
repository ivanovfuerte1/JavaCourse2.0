package com.sirma.itt.javacourse.designpatterns.abstractfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link MyClassFactory} contains a method for testing the classes for creating and
 * resizing figures.
 * 
 * XXX: if it's a runner class rename it so.
 */
public final class MyClassFactory {
	private static final Logger LOGGER = LogManager.getLogger(MyClassFactory.class);

	/**
	 * XXX: remove constructors
	 * 
	 * Default constructor.
	 */
	private MyClassFactory() {
	}

	/**
	 * XXX: Does not test anything.
	 * 
	 * Tests the methods for creating and resizing figures.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		AbstractFactory shapeFactory = MyClass.getFactory("Shape");
		Shape shapeRectangle = shapeFactory.getShape("Rectangle");
		LOGGER.info(shapeRectangle.create());
		Shape shapeSquare = shapeFactory.getShape("Square");
		LOGGER.info(shapeSquare.create());

		AbstractFactory sizefFactory = MyClass.getFactory("whatever");
		Size halfSize = sizefFactory.getSize("HalfSize");
		LOGGER.info(halfSize.resize());
		try {
			LOGGER.info(((Square) Class.forName(
					"com.sirma.itt.javacourse.designpatterns.abstractfactory.Square").newInstance())
					.create());
		} catch (InstantiationException e) {
			LOGGER.error("The specified class can not be instantiated.", e);
		} catch (IllegalAccessException e) {
			LOGGER.error(
					"The currently executing method does not have access to the definition of the specified class, field, method or constructor.",
					e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("No definition for the class with the specified name could be found.", e);
		}
	}
}
