package com.sirma.itt.javacourse.reflection.orderingobjects;

import java.util.Arrays;

/**
 * The class {@link OrderingObjects} contains a method for sorting an array of classes according to
 * {@link OrderAnnotation}.
 * 
 * @author Svetlosar Kovatchev
 */
public final class OrderingObjects {

	/**
	 * XXX: why default constructor?
	 * 
	 * Default constructor.
	 */
	private OrderingObjects() {
	}

	/**
	 * Creates an array of classes and sorts them according to the {@link OrderAnnotation}.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		ParentClass[] subClasses = { new FirstSubclass(), new SecondSubclass(),
				new ThirdSubclass(), new FourthClass() };
		Arrays.sort(subClasses);
		for (int i = 0; i < subClasses.length; i++) {
			// XXX: Logger!
			System.out.println(subClasses[i].getClass().getName());
		}
	}
}
