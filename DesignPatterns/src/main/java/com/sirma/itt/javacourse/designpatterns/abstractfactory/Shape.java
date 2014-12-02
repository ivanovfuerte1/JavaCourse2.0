package com.sirma.itt.javacourse.designpatterns.abstractfactory;

/**
 * The interface {@link Shape} contains a method for creating a different shape according to the
 * implementing class.
 */
public interface Shape {
	/**
	 * Creates a shape according to the implementing class.
	 * 
	 * @return the kind of shape
	 */
	String create();
}
