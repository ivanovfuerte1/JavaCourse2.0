package com.sirma.itt.javacourse.objects.hierarchyfigures;

/**
 * The class Circle contains methods for drawing, moving, resizing and erasing ellipses.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class Ellipse extends Circle {
	private Point center = null;
	private int majorAxis = 0;
	private int minorAxis = 0;

	@Override
	void draw() {
		System.out.println(center);

	}

	/**
	 * Returns the size of the majorAxis of the ellipse.
	 * 
	 * @return the majorAxis of the ellipse
	 */
	public int getMajorAxis() {
		return majorAxis;
	}

	/**
	 * Sets the size of the majorAxis of the ellipse.
	 * 
	 * @param majorAxis
	 *            the majorAxis of the ellipse
	 */
	public void setMajorAxis(int majorAxis) {
		this.majorAxis = majorAxis;
	}

	/**
	 * Returns the size of the minorAxis of the ellipse.
	 * 
	 * @return the minorAxis of the ellipse
	 */
	public int getMinorAxis() {
		return minorAxis;
	}

	/**
	 * Sets the size of the minorAxis of the ellipse.
	 * 
	 * @param minorAxis
	 *            the minorAxis of the ellipse
	 */
	public void setMinorAxis(int minorAxis) {
		this.minorAxis = minorAxis;
	}

}
