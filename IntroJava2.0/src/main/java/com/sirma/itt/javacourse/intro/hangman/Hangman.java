package com.sirma.itt.javacourse.intro.hangman;

import java.util.Scanner;

/**
 * The class Hangman implements methods for playing the game with the same name. The player has the
 * right to choose unlimited number of letters in order to guess the word whenever he or she doesn't
 * make six wrong choices.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class Hangman {
	/**
	 * The constant value of this field represents the maximum of wrong letter choices permitted. If
	 * the player exceeds this maximum he or she loses the game.
	 */
	private static final int MAXIMUM_WRONG_CHOICES = 5;
	private DataReader reader;
	private String correctAnswer;
	private static String wordToGuess = "java";
	private static Character[] userInterface = new Character[] { 'j', 'a', 'v', 'a' };
	private static Character[] wordToDisplay = new Character[] { '_', '_', '_', '_' };
	private int numberCorrectGuesses;
	private int numberWrongGuesses;
	private int numberUsedLetters = 0;
	private String[] usedLetters = new String[50];

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
		String data = reader.readString();
		if (correctAnswer.equals(data)) {
			System.out.println("Your guess is correct!");
			return true;
		} else {
			return wordChecker(wordToGuess);
		}
	}

	/**
	 * Checks if the word is recognized.
	 * 
	 * @param wordToGuess
	 *            The word player is supposed to guess.
	 * @return the result of the word checking.
	 */
	public boolean wordChecker(String wordToGuess) {
		String letter;
		Scanner scanner = null;

		while (numberCorrectGuesses < wordToGuess.length()
				&& numberWrongGuesses <= MAXIMUM_WRONG_CHOICES) {
			System.out.println("Guess a letter: ");
			for (int i = 0; i < wordToDisplay.length; i++) {
				System.out.print(" " + wordToDisplay[i] + " ");
			}
			System.out.println();
			scanner = new Scanner(System.in);
			letter = scanner.nextLine();
			if (correctAnswer.equals(letter)) {
				System.out.println("Your guess is correct!");
				scanner.close();
				return true;
			}
			String pattern = "[^a-z]{1}";
			if (letter.matches(pattern) || letter.length() != 1) {
				System.out.println("The character you entered is not in valid format!");
				continue;
			}
			letterSearcher(wordToGuess, letter);
		}
		for (int i = 0; i < wordToDisplay.length; i++) {
			System.out.print(" " + wordToDisplay[i] + " ");
		}
		System.out.println();
		if (numberCorrectGuesses == wordToGuess.length()) {
			System.out.println("You won! :)");
			return true;
		} else {
			System.out.println("You lost! :(");
			return false;
		}
	}

	/**
	 * This method looks in the word to find the guessing letter.
	 * 
	 * @param line
	 *            The word to guess.
	 * @param letterToCheck
	 *            The current letter to check for.
	 * @return returns the result of letter searching.
	 */

	public boolean letterSearcher(String line, String letterToCheck) {
		for (int k = 0; k < numberUsedLetters; k++) {
			if (letterToCheck.equalsIgnoreCase(usedLetters[k])) {
				System.out.println("You're repeating letters.");
				return false;
			}
		}
		usedLetters[numberUsedLetters] = letterToCheck;
		numberUsedLetters++;

		int counter = 0;
		int i = 0;
		int j = 0;
		do {
			i = line.indexOf(letterToCheck, j);
			if (i >= 0) {
				counter++;
				for (int m = 0; m < userInterface.length; m++) {
					if (letterToCheck.charAt(0) != userInterface[m]) {
						wordToDisplay[i] = userInterface[i];
					}
				}
			} else if (counter == 0) {
				System.out.println("Wrong Guess! :( ");
				numberWrongGuesses++;
			}
			j = i + 1;
		} while (i >= 0);
		numberCorrectGuesses += counter;
		if (counter > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Shows up the word to guess.
	 * 
	 * @return the word to play with
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * Sets a word to play with.
	 * 
	 * @param correctAnswer
	 *            the word to play with
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}