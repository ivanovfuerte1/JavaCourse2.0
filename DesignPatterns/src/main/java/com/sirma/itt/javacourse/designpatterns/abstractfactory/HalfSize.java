package com.sirma.itt.javacourse.designpatterns.abstractfactory;

/**
 * The class {@link HalfSize} contains a method for resizing figures at 50%.
 */
public class HalfSize implements Size {

	@Override
	public float resize() {
		return 0.5f;
	}

}
