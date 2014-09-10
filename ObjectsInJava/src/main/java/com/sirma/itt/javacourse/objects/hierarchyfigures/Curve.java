package com.sirma.itt.javacourse.objects.hierarchyfigures;

/**
 * The class Curve contains methods for drawing, moving, resizing and erasing ellipses.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class Curve extends Ellipse {
	private Point beginning;

	@Override
	void draw() {
		System.out.println(getxCoordinate());
		beginning = new Circle().getCenter();
		System.out.println(beginning);
	}

	/**
	 * Rotates the curve.
	 */
	void rotate() {

	}

}
