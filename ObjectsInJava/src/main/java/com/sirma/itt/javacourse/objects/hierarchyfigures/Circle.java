package com.sirma.itt.javacourse.objects.hierarchyfigures;

/**
 * The class Circle contains methods for drawing, moving, resizing and erasing circles.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class Circle extends Point {
	private Point center = null;
	private int radius = 0;

	@Override
	public void moveTo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub

	}

	@Override
	void draw() {
		// TODO Auto-generated method stub

	}

	/**
	 * Returns the coordinates of the center of the circle.
	 * 
	 * @return the center of the circle
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * Sets the coordinates of the center of the circle.
	 * 
	 * @param center
	 *            the center of the circle
	 */
	public void setCenter(Point center) {
		this.center = center;
	}

	/**
	 * Returns the coordinates of the radius of the circle.
	 * 
	 * @return the radius of the circle
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Sets the coordinates of the radius of the circle.
	 * 
	 * @param radius
	 *            the radius of the circle
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

}
