package com.sirma.itt.javacourse.libraries.hangman;

/**
 * The class HangmanPacked contains main method for testing and running the game Hangman from packed
 * jar file.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public final class HangmanPacked {
	/**
	 * Default constructor.
	 */
	private HangmanPacked() {
	}

	/**
	 * Runs the game Hangman from jar file.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		String[] answer = { "sese", "somethingElse", "e", "deer" };
		Hangman hangman = new Hangman(new TestHangmanInput(answer), "deer");
		System.out.println(hangman.play());
		Hangman consoleHangman = new Hangman(new ConsoleDataReader(), "deer");
		consoleHangman.play();
	}

}
