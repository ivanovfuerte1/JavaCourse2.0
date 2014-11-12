package com.sirma.itt.javacourse.reflection.instantiateclass;

/**
 * The class {@link Run} contains a method for testing the methods of the class
 * {@link InstantiateClass}.
 * 
 * @author Svetlosar Kovatchev
 */
public final class Run {
	private static final String CLASS_NAME = "com.sirma.itt.javacourse.reflection.instantiateclass.TestHangmanInput";

	/**
	 * Default constructor.
	 */
	private Run() {
	}

	/**
	 * Tests the methods outputParent and outputInterfaces of the class {@link InstantiateClass}
	 * with sample class.
	 * 
	 * @param args
	 *            default arguments
	 * @throws IllegalAccessException
	 *             when access to the current field or method is denied
	 * @throws InstantiationException
	 *             when the specified class object cannot be instantiated
	 * @throws ClassNotFoundException
	 *             when the method cannot find the class from the input.
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		InstantiateClass instantiateClass = new InstantiateClass();
		// XXX: NPE!
		instantiateClass.outputParent("java.lang.Object");
		instantiateClass.outputInterfaces(CLASS_NAME);
	}

}
