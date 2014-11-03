package com.sirma.itt.javacourse.inputoutput.serialization;

import java.io.Serializable;

/**
 * The class {@link UserDefinedObject} contains a method for displaying a string.
 * 
 * @author Svetlosar Kovatchev
 */
public class UserDefinedObject implements Serializable {

	/**
	 * Generated serialVersionUID.
	 */
	private static final long serialVersionUID = -769258840545964661L;
	private String sampleString = "Sample string";
	private int count = 3;

	/**
	 * Displays a string as many times as the value of 'count' is.
	 */
	public void displayString() {
		for (int i = 0; i < count; i++) {
			System.out.println(sampleString);
		}
	}

}
