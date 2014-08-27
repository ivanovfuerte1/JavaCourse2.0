package com.sirma.itt.javacourse.intro.hangman;

import org.junit.Assert;
import org.junit.Test;

/**
 * The class HangmanTest test the methods of Hangman with sample strings.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class HangmanTest {
	private String correctAnswer = "Answer";
	private String[] letterToSearch = { "a", "s", "d", "f", "g", "h", "j", "k", "j" };

	/**
	 * Tests the method play of the class Hangman with correct answer.
	 */
	@Test
	public void testPlayWithCorrectData() {
		Hangman hangman = new Hangman(new TestDataReader("Answer"), correctAnswer);
		Assert.assertEquals(true, hangman.play());
	}

	/**
	 * Tests the method letterToSearch of the class Hangman with wrong answer.
	 */
	@Test
	public void testPlayWithWrongData() {
		Hangman hangman = new Hangman(new TestDataReader("Answer"), correctAnswer);
		int wrongAnswers = 0;
		boolean result = true;
		for (int i = 1; i < letterToSearch.length && i < (correctAnswer.length() + 5); i++) {
			if (!hangman.letterSearcher(correctAnswer, letterToSearch[i])) {
				wrongAnswers++;
			}
		}
		if (wrongAnswers > 5) {
			result = false;
		}
		Assert.assertEquals(false, result);
	}

	/**
	 * The class TestDataReader is nested in order to supply a string for the testing methods of the
	 * class HangmanTest.
	 * 
	 * @author Svetlosar Kovatchev
	 * @version 2.0
	 */
	private static class TestDataReader implements DataReader {
		private String data;

		/**
		 * Assigns data to the default object.
		 * 
		 * @param data
		 *            the data assigned
		 */
		public TestDataReader(String data) {
			this.data = data;
		}

		@Override
		public String readString() {
			return data;
		}

	}

}