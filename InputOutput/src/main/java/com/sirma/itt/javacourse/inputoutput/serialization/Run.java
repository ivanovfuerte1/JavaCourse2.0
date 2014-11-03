package com.sirma.itt.javacourse.inputoutput.serialization;

import java.io.IOException;

/**
 * The class {@link Run} contains a method for testing the methods of the class {@link DataClass}
 * for serializing and deserializing objects.
 * 
 * @author Svetlosar Kovatchev
 */
public final class Run {
	private static final String SAMPLE_FILE = "FileToBeSerialized.ser";

	/**
	 * Default constructor.
	 */
	private Run() {
	}

	/**
	 * Tests the methods of the class {@link DataClass} by serializing and deserializing an object
	 * of the class {@link UserDefinedObject} using a sample file.
	 * 
	 * @param args
	 *            at
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 * @throws ClassNotFoundException
	 *             if a class cannot be found
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		DataClass serialization = new DataClass();
		UserDefinedObject printerOfStrings = new UserDefinedObject();
		serialization.saveObject(SAMPLE_FILE, printerOfStrings);
		UserDefinedObject objectRead = serialization.getObject(SAMPLE_FILE);
		objectRead.displayString();
	}

}
