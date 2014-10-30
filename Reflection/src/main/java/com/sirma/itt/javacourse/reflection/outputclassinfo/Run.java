package com.sirma.itt.javacourse.reflection.outputclassinfo;

/**
 * The class {@link Run} contains a method for testing the methods of the class
 * {@link OutputClassInfo}.
 * 
 * @author Svetlosar Kovatchev
 */
public final class Run {
	private static final String CLASS_NAME = "com.sirma.itt.javacourse.reflection.outputclassinfo.HeterogeneousTreeNode";

	/**
	 * Default constructor.
	 */
	private Run() {
	}

	/**
	 * Tests the methods outputMethodInfo and outputFieldInfo of the class {@link OutputClassInfo}
	 * with sample class.
	 * 
	 * @param args
	 *            default arguments
	 * @throws ClassNotFoundException
	 *             if the class cannot be accessed or does not exist
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		OutputClassInfo outputClassInfo = new OutputClassInfo();
		outputClassInfo.outputMethodInfo(CLASS_NAME);
		outputClassInfo.outputFieldInfo(CLASS_NAME);
	}
}
