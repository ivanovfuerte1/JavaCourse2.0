package com.sirma.itt.javacourse.objects.hierarchyfigures;

/**
 * The class Curve contains methods for drawing and rotating curves.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class Curve extends Ellipse {
	private Point beginning;

	@Override
	protected void draw() {
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
