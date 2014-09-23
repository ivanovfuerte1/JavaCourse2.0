package com.sirma.itt.javacourse.libraries.summinglargenumbers;

/**
 * The class {@link SummingNumbersPacked} contains main method for testing the methods of
 * {@link SummingLargeNumbers}.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public final class SummingNumbersPacked {
	/**
	 * Default constructor.
	 */
	private SummingNumbersPacked() {
	}

	/**
	 * Tests the method sumLargeNumbers from a jar file.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		System.out.println(SummingLargeNumbers
				.sumLargeNumbers("18888877777777799999999999000000000002",
						"266666688888888555555555557777777777778"));
	}

}
