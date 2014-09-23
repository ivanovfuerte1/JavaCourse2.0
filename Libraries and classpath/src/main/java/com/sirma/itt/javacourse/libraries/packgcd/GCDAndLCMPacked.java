package com.sirma.itt.javacourse.libraries.packgcd;

/**
 * The class {@link GCDAndLCMPacked} contains main method for testing the methods of
 * {@link GCDAndLCM}.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public final class GCDAndLCMPacked {
	/**
	 * Default arguments.
	 */
	private GCDAndLCMPacked() {
	}

	/**
	 * Tests the methods findGCD and findLCM from a jar file.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		System.out.println(GCDAndLCM.findGCD(6, 10));
		System.out.println(GCDAndLCM.findLCM(6, 15));
	}
}
