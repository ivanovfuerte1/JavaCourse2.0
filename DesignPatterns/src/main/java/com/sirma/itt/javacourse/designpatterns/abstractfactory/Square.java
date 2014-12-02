package com.sirma.itt.javacourse.designpatterns.abstractfactory;

/**
 * The class {@link Square} contains a method for creating a square without implementation.
 */
public class Square implements Shape {

	@Override
	public String create() {
		return "A square has been created";
	}

}
