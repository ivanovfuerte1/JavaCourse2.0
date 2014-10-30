package com.sirma.itt.javacourse.reflection.orderingobjects;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link OrderingObjects} contains a method for sorting an array of classes according to
 * {@link OrderAnnotation}.
 * 
 * @author Svetlosar Kovatchev
 */
public class OrderingObjects {
	private static final Logger LOGGER = LogManager.getLogger(OrderingObjects.class);

	/**
	 * Default constructor.
	 */
	public OrderingObjects() {
	}

	/**
	 * Creates an array of classes and sorts them according to the {@link OrderAnnotation}.
	 * 
	 * @param subClasses
	 *            the classes for being ordered
	 */
	public void sortClasses(ParentClass[] subClasses) {
		Arrays.sort(subClasses);
		for (int i = 0; i < subClasses.length; i++) {
			LOGGER.info(subClasses[i].getClass().getSimpleName());
		}
	}
}
