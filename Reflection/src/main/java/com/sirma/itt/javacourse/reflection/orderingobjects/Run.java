package com.sirma.itt.javacourse.reflection.orderingobjects;

/**
 * The class {@link Run} contains methods for testing the method sortClasses of the class
 * {@link OrderingObjects}.
 * 
 * @author Svetlosar Kovatchev
 */
public final class Run {

	/**
	 * Default constructor.
	 */
	private Run() {
	}

	/**
	 * Tests the method sortClasses of the class {@link OrderingObjects} with sample classes.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		ParentClass[] subClasses = { new FirstSubclass(), new SecondSubclass(),
				new ThirdSubclass(), new FourthSubclass() };
		OrderingObjects orderingObjects = new OrderingObjects();
		orderingObjects.sortClasses(subClasses);
	}

}
