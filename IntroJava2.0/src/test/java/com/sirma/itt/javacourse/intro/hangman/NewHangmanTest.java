package com.sirma.itt.javacourse.intro.hangman;

import org.junit.Assert;
import org.junit.Test;

/**
 * The class NewHangmanTest test the methods of Hangman with sample strings.
 * 
 * @author Svetlosar Kovatchev
 * @version 3.0
 */
public class NewHangmanTest implements DataReader {

	private String[] answer = { "sese", "somethingElse", "e", "deer" };
	private String[] wrongAnswer = { "seee", "a", "b", "c", "d", "f", "g", "q", "w" };

	/**
	 * Tests the method play of the class Hangman with correct answer.
	 */
	@Test
	public void testPlayCorrectAnswer() {
		Hangman hangman = new Hangman(new TestHangmanInput(answer), "deer");
		Assert.assertEquals(true, hangman.play());
	}

	/**
	 * Tests the method play of the class Hangman with wrong answer.
	 */
	@Test
	public void testPlayWrongAnswer() {
		Hangman hangman = new Hangman(new TestHangmanInput(wrongAnswer), "deer");
		Assert.assertEquals(false, hangman.play());
	}

	@Override
	public String readUserInput() {
		return null;
	}

}
