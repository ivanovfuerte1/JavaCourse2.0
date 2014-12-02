package com.sirma.itt.javacourse.designpatterns.abstractfactory;

/**
 * The class {@link ShapeFactory} contains a method for getting a figure created by a class
 * implementing the interface {@link Shape}, and an empty method.
 */
public class ShapeFactory extends AbstractFactory {
	private static final String RECTANGLE = "Rectangle";
	private static final String SQUARE = "Square";

	@Override
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase(RECTANGLE)) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase(SQUARE)) {
			return new Square();
		}
		return null;
	}

	@Override
	public Size getSize(String size) {
		return null;
	}

}
