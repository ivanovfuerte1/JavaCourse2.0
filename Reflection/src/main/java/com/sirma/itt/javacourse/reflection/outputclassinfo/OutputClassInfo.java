package com.sirma.itt.javacourse.reflection.outputclassinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class OutputClassInfo contains a methods for displaying information about the methods and the
 * fields of a class.
 * 
 * @author Svetlosar Kovatchev
 */
public class OutputClassInfo {
	private static final Logger LOGGER = LogManager.getLogger(OutputClassInfo.class);

	/**
	 * Displays method signatures of the class from the input.
	 * 
	 * @param className
	 *            the name of the class
	 */
	public void outputMethodInfo(String className) {
		try {
			Class<?> c = Class.forName(className);
			Method[] allMethods = c.getDeclaredMethods();
			int i = 0;
			for (Method m : allMethods) {
				// The output is formatted in the next few lines so that method signatures appear
				// the way they are.
				StringBuilder sb = new StringBuilder();
				sb.append(m.getReturnType().getSimpleName());
				sb.append(" ");
				sb.append(m.getName());
				sb.append("(");
				if (m.getParameterTypes().length > 1) {
					for (i = 0; i < m.getParameterTypes().length - 1; i++) {
						sb.append(m.getParameterTypes()[i].getSimpleName());
						sb.append(", ");
					}
				}
				for (int j = i; j < m.getParameterTypes().length; j++) {
					sb.append(m.getParameterTypes()[j].getSimpleName());
				}

				sb.append(")");
				LOGGER.info(sb);
			}
		} catch (ClassNotFoundException e) {
			LOGGER.info("The class was not found");
		}

	}

	/**
	 * Displays fields with their types and values of the class from the input.
	 * 
	 * @param className
	 *            the name of the class
	 * @throws ClassNotFoundException
	 *             if the class cannot be accessed or does not exist
	 */
	public void outputFieldInfo(String className) throws ClassNotFoundException {
		Class<?> c = Class.forName(className);
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			StringBuilder sb = new StringBuilder();
			try {
				// The next row throws IllegalAccessException in case the field has no value
				// assigned.
				String value = fields[i].get(c).toString();
				sb.append("Type: ");
				sb.append(fields[i].getType());
				sb.append(" Name: ");
				sb.append(fields[i].getName());
				sb.append(" Value: ");
				sb.append(value);
				LOGGER.info(sb);
			} catch (IllegalAccessException e) {
				sb.append("Type: ");
				sb.append(fields[i].getType());
				sb.append(" Name: ");
				sb.append(fields[i].getName());
				LOGGER.info(sb);
				continue;
			}
		}
	}
}
