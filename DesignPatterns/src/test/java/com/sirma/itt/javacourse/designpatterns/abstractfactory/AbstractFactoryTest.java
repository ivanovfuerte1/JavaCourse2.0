package com.sirma.itt.javacourse.designpatterns.abstractfactory;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * The class {@link AbstractFactoryTest} contains methods for testing the methods for creating and
 * resizing figures as well as the factories for choosing the correct implementing class.
 * 
 * @author Svetlosar Kovatchev
 */
public class AbstractFactoryTest {
	private static final Logger LOGGER = LogManager.getLogger(AbstractFactoryTest.class);

	/**
	 * Tests the default constructor of MyClass with the method resize of the class {@link HalfSize}
	 * .
	 */
	@Test
	public void testSize() {
		AbstractFactory sizefFactory = MyClass.getFactory("whatever");
		Size halfSize = sizefFactory.getSize("HalfSize");
		float result = halfSize.resize();
		float expected = 0.5f;
		assertEquals(expected, result, 0.01f);
	}

	/**
	 * Test the constructor for {@link ShapeFactory} with the method create of the class
	 * {@link Rectangle}.
	 */
	@Test
	public void testShape() {
		AbstractFactory shapeFactory = MyClass.getFactory("Shape");
		Shape shapeRectangle = shapeFactory.getShape("Rectangle");
		String result = shapeRectangle.create();
		String expected = "A rectangle has been created";
		assertEquals(expected, result);
	}

	/**
	 * Tests the method create of the class {@link Square} by reflection.
	 */
	@Test
	public void testReflection() {
		String result = null;
		try {
			result = ((Square) Class.forName(
					"com.sirma.itt.javacourse.designpatterns.abstractfactory.Square").newInstance())
					.create();
		} catch (InstantiationException e) {
			LOGGER.error("The specified class object cannot be instantiated", e);
		} catch (IllegalAccessException e) {
			LOGGER.error(
					"The currently executing method does not have access to the definition of the specified class, field, method or constructor",
					e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("No definition for the class with the specified name could be found", e);
		}
		String expected = "A square has been created";
		assertEquals(expected, result);
	}

	/**
	 * Tests the method create for inexistent class.
	 * 
	 * @throws ClassNotFoundException
	 *             if no definition for the class with the specified name could be found
	 */
	@Test(expected = ClassNotFoundException.class)
	public void testReflectionException() throws ClassNotFoundException {
		String result = null;
		try {
			result = ((Square) Class.forName(
					"com.sirma.itt.javacourse.designpatterns.abstractfactory.Cube").newInstance())
					.create();
		} catch (InstantiationException e) {
			LOGGER.error("The specified class object cannot be instantiated", e);
		} catch (IllegalAccessException e) {
			LOGGER.error(
					"The currently executing method does not have access to the definition of the specified class, field, method or constructor",
					e);
		}
		String expected = null;
		assertEquals(expected, result);
	}

}
