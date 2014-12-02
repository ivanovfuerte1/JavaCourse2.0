package com.sirma.itt.javacourse.designpatterns.abstractfactory;

/**
 * The class {@link Rectangle} contains a method for creating a rectangle without implementation.
 */
public class Rectangle implements Shape {

	@Override
	public String create() {
		return "A rectangle has been created";
	}

}
