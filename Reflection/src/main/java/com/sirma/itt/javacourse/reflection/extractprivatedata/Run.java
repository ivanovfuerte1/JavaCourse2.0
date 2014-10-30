package com.sirma.itt.javacourse.reflection.extractprivatedata;

import java.lang.reflect.InvocationTargetException;

/**
 * The class {@link Run} contains a method for testing the methods of the class
 * {@link ExtractPrivateData}.
 * 
 * @author Svetlosar Kovatchev
 */
public final class Run {
	private static String className = "com.sirma.itt.javacourse.reflection.extractprivatedata.MyClass";

	/**
	 * Default constructor.
	 */
	private Run() {
	}

	/**
	 * Tests the methods invokeMethods and displayFields of the class {@link ExtractPrivateData}
	 * with sample class.
	 * 
	 * @param args
	 *            default arguments
	 * @throws InvocationTargetException
	 *             wraps an exception thrown by an invoked method
	 * @throws NoSuchMethodException
	 *             when the method is not found
	 * @throws IllegalAccessException
	 *             when the class cannot be instantiated or a method cannot be invoked
	 * @throws InstantiationException
	 *             when the class cannot be instantiated
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException {
		ExtractPrivateData privateData = new ExtractPrivateData();
		privateData.invokeMethods(className);
		privateData.displayFields(className);
	}

}
