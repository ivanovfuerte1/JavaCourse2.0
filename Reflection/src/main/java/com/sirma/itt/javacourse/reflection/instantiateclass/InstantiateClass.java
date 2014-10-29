package com.sirma.itt.javacourse.reflection.instantiateclass;

import static java.lang.System.out;

/**
 * The class contains a method for displaying the superclass and the interfaces of the instantiated
 * class.
 * 
 * @author Svetlosar Kovatchev
 */
public final class InstantiateClass {
	/**
	 * Default constructor.
	 */
	private InstantiateClass() {
	}

	/**
	 * XXX: why main method? Split methods?
	 * 
	 * Displays the superclass and interfaces of the instantiated class.
	 * 
	 * @param args
	 *            default arguments
	 * @throws ClassNotFoundException
	 *             when the method cannot find the class from the input.
	 * @throws InstantiationException
	 *             when the specified class object cannot be instantiated
	 * @throws IllegalAccessException
	 *             when access to the current field or method is denied
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		// XXX: Again hard coded constants?
		Class<?> myClassInstance = Class
				.forName("com.sirma.itt.javacourse.reflection.instantiateclass.TestHangmanInput");

		Class<?> parent = myClassInstance.getSuperclass();
		// XXX: Logger!
		out.println(parent.getSimpleName());

		Class<?>[] interfaces = myClassInstance.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			out.println(interfaces[i]);
		}
	}

}
