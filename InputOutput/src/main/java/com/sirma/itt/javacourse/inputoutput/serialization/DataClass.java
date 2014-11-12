package com.sirma.itt.javacourse.inputoutput.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The class {@link DataClass} contains methods for serializing and deserializing.
 * 
 * @author Svetlosar Kovatchev
 * 
 * XXX: How can you read multiple serialzied objects?
 * 
 */
public class DataClass {
	/**
	 * Serializes the parameter 'o' in the 'path' file. If such a file does not exist it is being
	 * created.
	 * 
	 * @param path
	 *            the destination file for saving data
	 * @param o
	 *            data to be saved in the destination file
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public void saveObject(String path, UserDefinedObject o) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
			out.writeObject(o);
			out.flush();
		}
	}

	/**
	 * Reads the instance of the class {@link UserDefinedObject} in the 'path' destination and
	 * returns object of it as a result. This method work only for {@link UserDefinedObject}. In
	 * order to work with other classes the method return type should be Object.
	 * 
	 * @param path
	 *            the destination file where the instance of the class {@link UserDefinedObject} is
	 *            saved
	 * @return the instance of the class {@link UserDefinedObject} read from the destination file
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 * @throws ClassNotFoundException
	 *             if a class cannot be found
	 */
	public UserDefinedObject getObject(String path) throws IOException, ClassNotFoundException {
		UserDefinedObject myObject = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
			myObject = (UserDefinedObject) in.readObject();
		}
		return myObject;
	}
}
