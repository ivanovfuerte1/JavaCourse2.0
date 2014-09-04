package com.sirma.itt.javacourse.intro.hangman;

/**
 * The class Hangman implements methods for playing the game with the same name. The player has the
 * right to choose unlimited number of letters in order to guess the word whenever he or she doesn't
 * make six wrong choices.
 * 
 * @author Svetlosar Kovatchev
 * @version 3.0
 */
public class Hangman {
	private static final int MAXIMUM_WRONG_CHOICES = 5;
	private DataReader reader;
	private String correctAnswer;
	private int numberWrongGuesses;
	private int numberCorrectGuesses;
	private int numberUsedLetters;
	private int maximumGuesses;
	private char[] usedLetters;

	/**
	 * Assigns data to the default object.
	 * 
	 * @param reader
	 *            the reader for this answer
	 * @param correctAnswer
	 *            a correct answer
	 */
	public Hangman(DataReader reader, String correctAnswer) {
		this.reader = reader;
		this.correctAnswer = correctAnswer;
	}

	/**
	 * Checks the guessed word with the correct answer.
	 * 
	 * @return true in case the answer is correct and false otherwise
	 */
	public boolean play() {
		maximumGuesses = MAXIMUM_WRONG_CHOICES + correctAnswer.length();
		usedLetters = new char[maximumGuesses];
		char[] wordToDisplay = new char[correctAnswer.length()];
		System.out.println("Guess the whole word");
		for (int i = 0; i < correctAnswer.length(); i++) {
			wordToDisplay[i] = '_';
		}
		for (int i = 0; i < wordToDisplay.length; i++) {
			System.out.print(" " + wordToDisplay[i] + " ");
		}
		System.out.println();
		String data = reader.readUserInput();
		if (correctAnswer.equals(data)) {
			System.out.println("You won! :)");
			return true;
		} else {
			while (numberCorrectGuesses < correctAnswer.length()
					&& numberWrongGuesses <= MAXIMUM_WRONG_CHOICES) {
				for (int i = 0; i < wordToDisplay.length; i++) {
					System.out.print(" " + wordToDisplay[i] + " ");
				}
				System.out.println();
				String letter = reader.readUserInput();
				if (correctAnswer.equals(letter)) {
					System.out.println("You won! :)");
					return true;
				} else {
					String pattern = "[^a-z]{1}";
					if (letter.matches(pattern) || letter.length() != 1) {
						System.out.println("The character you entered is not in valid format");
						continue;
					}
					char firstLetter = letter.charAt(0);
					letterSearcher(correctAnswer, firstLetter, wordToDisplay);
				}
			}
			for (int i = 0; i < wordToDisplay.length; i++) {
				System.out.print(" " + wordToDisplay[i] + " ");
			}
			System.out.println();
			if (numberCorrectGuesses == wordToDisplay.length) {
				System.out.println("You won! :)");
				return true;
			} else {
				System.out.println("You lost! :(");
				return false;
			}
		}
	}

	/**
	 * This method looks in the word to find the guessing letter.
	 * 
	 * @param correctGuess
	 *            The word to guess.
	 * @param currentLetter
	 *            The current letter to check for.
	 * @param correctedWordToDisplay
	 *            a sequence of bottom dashes and the guessed correct letters
	 * @return returns the result of letter searching.
	 */
	private boolean letterSearcher(String correctGuess, char currentLetter,
			char[] correctedWordToDisplay) {

		for (int i = 0; i < numberUsedLetters; i++) {
			if (currentLetter == usedLetters[i]) {
				System.out.println("You're repeating letters.");
				return false;
			}
		}
		usedLetters[numberUsedLetters] = currentLetter;
		numberUsedLetters++;

		int counter = 0;
		int i = 0;
		int j = 0;

		do {
			for (int k = j; k < correctGuess.length(); k++) {
				if (currentLetter == correctGuess.charAt(k)) {
					i = k;
					break;
				} else {
					i = -1;
				}
			}
			if (i >= 0) {
				counter++;
				for (int m = 0; m < correctAnswer.length(); m++) {
					if (currentLetter != correctAnswer.charAt(m)) {
						correctedWordToDisplay[i] = correctAnswer.charAt(i);
					}
				}
			} else if (counter == 0) {
				System.out.println("Wrong guess! :( ");
				numberWrongGuesses++;
			}
			j = i + 1;
		} while (i >= 0 && j != correctAnswer.length());
		numberCorrectGuesses += counter;
		if (counter > 0) {
			return true;
		}
		return false;
	}
}
