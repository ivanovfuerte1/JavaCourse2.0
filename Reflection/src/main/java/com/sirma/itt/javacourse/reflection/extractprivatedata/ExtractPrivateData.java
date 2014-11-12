package com.sirma.itt.javacourse.reflection.extractprivatedata;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link ExtractPrivateData} contains methods for invoking private methods and displaying
 * the values of the private fields.
 * 
 * @author Svetlosar Kovatchev
 */
public class ExtractPrivateData {
	private static final Logger LOGGER = LogManager.getLogger(ExtractPrivateData.class);

	/**
	 * Instantiate a class and invokes its methods.
	 * 
	 * @param className
	 *            the name of the class
	 * @throws IllegalAccessException
	 *             when the class cannot be instantiated or a method cannot be invoked
	 * @throws InstantiationException
	 *             when the class cannot be instantiated
	 * @throws NoSuchMethodException
	 *             when the method is not found
	 * @throws InvocationTargetException
	 *             wraps an exception thrown by an invoked method
	 */
	public void invokeMethods(String className) throws InstantiationException,
			IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		try {

			Class<?>[] paramString = new Class[1];
			paramString[0] = String.class;

			Class<?> myClass = Class.forName(className);
			Object object = myClass.newInstance();

			// XXX: constant
			Method myMethod = myClass.getDeclaredMethod("print", paramString);
			myMethod.setAccessible(true);
			myMethod.invoke(object, new String("I'm a string"));

			Method[] allMethods = myClass.getDeclaredMethods();
			for (Method method : allMethods) {
				if (Modifier.isPrivate(method.getModifiers())) {
					LOGGER.info(method.getName() + "()");
				}
			}

			MyClass sampleClass = new MyClass();

			Class<?> myOtherClass = sampleClass.getClass();
			Method[] methods = myOtherClass.getDeclaredMethods();
			methods[1].setAccessible(true);
			LOGGER.info(methods[1].invoke(sampleClass));
		} catch (ClassNotFoundException e) {
			LOGGER.info("The class was not found");
		}
	}

	/**
	 * Instantiate a class and displays its fields with the correspondent values.
	 * 
	 * @param className
	 *            the name of the class
	 * @throws IllegalAccessException
	 *             when the class cannot be instantiated or a method cannot be invoked
	 * @throws InstantiationException
	 *             when the class cannot be instantiated
	 */
	public void displayFields(String className) throws IllegalAccessException,
			InstantiationException {
		try {
			Class<?> myClass = Class.forName(className);
			MyClass sampleClass = new MyClass();
			Field[] allFields = myClass.getDeclaredFields();
			for (Field field : allFields) {
				if (Modifier.isPrivate(field.getModifiers())) {
					field.setAccessible(true);
					StringBuilder sb = new StringBuilder();
					sb.append("Name: ");
					sb.append(field.getName());
					sb.append("; Value: ");
					sb.append(field.get(sampleClass));
					LOGGER.info(sb);
				}
			}
		} catch (ClassNotFoundException e) {
			LOGGER.info("The class was not found");
		}
	}
}
