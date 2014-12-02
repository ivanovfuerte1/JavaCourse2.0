package com.sirma.itt.javacourse.designpatterns.abstractfactory;

/**
 * The abstract class {@link AbstractFactory} contains methods for getting a figure and getting the
 * ratio of a resized figure.
 * 
 * @author Svetlosar Kovatchev
 */
public abstract class AbstractFactory {
	/**
	 * Returns the figure created by the corresponding factory.
	 * 
	 * @param shape
	 *            the figure to be created
	 * @return the result of creating the figure
	 */
	public abstract Shape getShape(String shape);

	/**
	 * Returns the ratio of a resized figure to the initial one.
	 * 
	 * @param size
	 *            the class used for resizing the figure
	 * @return the ratio of a resized figure
	 */
	public abstract Size getSize(String size);
}
