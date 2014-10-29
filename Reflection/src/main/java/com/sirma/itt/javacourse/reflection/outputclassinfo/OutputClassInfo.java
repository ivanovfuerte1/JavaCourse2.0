package com.sirma.itt.javacourse.reflection.outputclassinfo;

import static java.lang.System.out;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * The class OutputClassInfo contains a method for displaying information about
 * a class.
 * 
 * @author Svetlosar Kovatchev
 */
public final class OutputClassInfo {

	/**
	 * XXX: do you need to implement default constructor?
	 * 
	 * Default constructor.
	 */
	private OutputClassInfo() {
	}

	/**
	 * XXX: why main method? Why in one method?
	 * 
	 * Displays method signatures and fields with their types and values of the
	 * current class.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String... args) {
		try {
			// XXX: Why hardcode this? How else can you implement it?
			Class<?> c = Class
					.forName("com.sirma.itt.javacourse.reflection.outputclassinfo.HeterogeneousTreeNode");
			Method[] allMethods = c.getDeclaredMethods();
			for (Method m : allMethods) {
				// XXX: use loggers! Perhaps format the output somehow?
				out.println(m.toString());
			}
			Field[] fields = c.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				try {
					out.format("Type: %s Name: %s Value: %s%n",
							fields[i].getType(), fields[i].getName(),
							fields[i].get(c));
				} catch (IllegalAccessException e) {
					out.format("Type: %s Name: %s%n", fields[i].getType(),
							fields[i].getName());
					continue;
				}
			}
		} catch (ClassNotFoundException e) {
			out.println("The class was not found");
		}

	}
}
