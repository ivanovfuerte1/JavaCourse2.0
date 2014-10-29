package com.sirma.itt.javacourse.reflection.extractprivatedata;

import static java.lang.System.out;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * The class ExtractPrivateData contains a method for invoking private methods and displaying the
 * values of the private fields.
 * 
 * @author Svetlosar Kovatchev
 */
public final class ExtractPrivateData {
	/**
	 * Default constructor.
	 */
	private ExtractPrivateData() {
	}

	/**
	 * XXX: Why main? Why default constructor? Why sysout?
	 * 
	 * Instantiate a class, invokes its methods and displays its fields with the correspondent
	 * values.
	 * 
	 * @param args
	 *            default arguments
	 * @throws IllegalAccessException
	 *             when the class cannot be instantiated or a method cannot be invoked
	 * @throws InstantiationException
	 *             when the class cannot be instantiated
	 * @throws NoSuchMethodException
	 *             when the method is not found
	 * @throws InvocationTargetException
	 *             wraps an exception thrown by an invoked method
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException {
		try {

			Class<?>[] paramString = new Class[1];
			paramString[0] = String.class;

			Class<?> myClass = Class
					.forName("com.sirma.itt.javacourse.reflection.extractprivatedata.MyClass");
			Object object = myClass.newInstance();

			Method myMethod = myClass.getDeclaredMethod("print", paramString);
			myMethod.setAccessible(true);
			myMethod.invoke(object, new String("I'm a string"));

			Method[] allMethods = myClass.getDeclaredMethods();
			for (Method method : allMethods) {
				if (Modifier.isPrivate(method.getModifiers())) {
					out.println(method.getName() + "()");
				}
			}

			MyClass sampleClass = new MyClass();

			Class<?> myOtherClass = sampleClass.getClass();
			Method[] methods = myOtherClass.getDeclaredMethods();
			methods[1].setAccessible(true);
			System.out.println(methods[1].invoke(sampleClass));

			Field[] allFields = myClass.getDeclaredFields();
			for (Field field : allFields) {
				if (Modifier.isPrivate(field.getModifiers())) {
					field.setAccessible(true);
					out.println("Name: " + field.getName() + "; Value: " + field.get(sampleClass));
				}
			}
		} catch (ClassNotFoundException e) {
			out.println("The class was not found");
		}
	}
}
