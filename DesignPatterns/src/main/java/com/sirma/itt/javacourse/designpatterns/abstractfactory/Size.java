package com.sirma.itt.javacourse.designpatterns.abstractfactory;

/**
 * The interface {@link Size} contains a method for resizing figures according to the implementing
 * class.
 */
public interface Size {
	/**
	 * Resizes figures according to the implementing class.
	 * 
	 * @return the ratio to the initial size
	 */
	float resize();
}
