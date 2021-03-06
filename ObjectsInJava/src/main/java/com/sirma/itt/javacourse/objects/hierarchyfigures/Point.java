package com.sirma.itt.javacourse.objects.hierarchyfigures;

/**
 * The class Point contains methods for drawing, moving and erasing circles.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class Point extends Figure {
	private int xCoordinate;
	private int yCoordinate;

	/**
	 * Moves the object to the destination by the coordinates of its center or beginning point.
	 */
	protected void moveTo() {
	}

	/**
	 * Erases the object.
	 */
	protected void erase() {
	}

	@Override
	protected void draw() {
	}

	/**
	 * Returns the x-coordinate of the point.
	 * 
	 * @return the x-coordinate
	 */
	public int getxCoordinate() {
		return xCoordinate;
	}

	/**
	 * Sets the x-coordinate of the point.
	 * 
	 * @param xCoordinate
	 *            the x-coordinate
	 */
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	/**
	 * Returns the y-coordinate of the point.
	 * 
	 * @return the y-coordinate
	 */
	public int getyCoordinate() {
		return yCoordinate;
	}

	/**
	 * Sets the y-coordinate of the point.
	 * 
	 * @param yCoordinate
	 *            the y-coordinate
	 */
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

}
