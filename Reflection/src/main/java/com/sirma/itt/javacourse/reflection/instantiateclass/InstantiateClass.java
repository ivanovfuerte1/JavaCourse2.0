package com.sirma.itt.javacourse.reflection.instantiateclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.itt.javacourse.reflection.outputclassinfo.OutputClassInfo;

/**
 * The class contains a method for displaying the superclass and the interfaces of the instantiated
 * class.
 * 
 * @author Svetlosar Kovatchev
 */
public class InstantiateClass {
	private static final Logger LOGGER = LogManager.getLogger(OutputClassInfo.class);

	/**
	 * Displays the superclass of the instantiated class.
	 * 
	 * @throws ClassNotFoundException
	 *             when the method cannot find the class from the input.
	 * @throws InstantiationException
	 *             when the specified class object cannot be instantiated
	 * @throws IllegalAccessException
	 *             when access to the current field or method is denied
	 * @param className
	 *            the name of the class
	 */
	public void outputParent(String className) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class<?> myClassInstance = Class.forName(className);

		Class<?> parent = myClassInstance.getSuperclass();
		LOGGER.info(parent.getSimpleName());
	}

	/**
	 * Displays the interfaces of the instantiated class.
	 * 
	 * @throws ClassNotFoundException
	 *             when the method cannot find the class from the input.
	 * @param className
	 *            the name of the class
	 */
	public void outputInterfaces(String className) throws ClassNotFoundException {
		Class<?> myClassInstance = Class.forName(className);
		Class<?>[] interfaces = myClassInstance.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			LOGGER.info(interfaces[i].getSimpleName());
		}
	}

}
