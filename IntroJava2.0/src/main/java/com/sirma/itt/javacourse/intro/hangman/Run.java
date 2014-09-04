package com.sirma.itt.javacourse.intro.hangman;

/**
 * The class Run contains method for playing the game Hangman from the console.
 * 
 * @author Svetlosar Kovatchev
 * @version 3.0
 */
public final class Run {
	/**
	 * Empty constructor.
	 */
	private Run() {

	}

	/**
	 * The main method plays the game Hangman from the console.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String... args) {
		Hangman hangman = new Hangman(new ConsoleDataReader(), "deer");
		hangman.play();
	}
}
