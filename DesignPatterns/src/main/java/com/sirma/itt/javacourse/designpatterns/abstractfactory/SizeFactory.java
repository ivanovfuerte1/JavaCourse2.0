package com.sirma.itt.javacourse.designpatterns.abstractfactory;

/**
 * The class {@link SizeFactory} contains a method for getting the ratio of a resized figure of a
 * class implementing the interface {@link Shape}, and an empty method.
 */
public class SizeFactory extends AbstractFactory {
	private static final String HALFSIZE = "HalfSize";

	@Override
	public Shape getShape(String shape) {
		return null;
	}

	@Override
	public Size getSize(String size) {
		if (size == null) {
			return null;
		}
		if (size.equalsIgnoreCase(HALFSIZE)) {
			return new HalfSize();
		}
		return null;
	}

}
