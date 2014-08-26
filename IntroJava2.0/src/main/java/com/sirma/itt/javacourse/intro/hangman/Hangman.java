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
	private DataReader reader2;
	private String correctAnswer;
	private static String wordToGuess = "car";
	private int numberCorrectGuesses;
	private int numberWrongGuesses;

	/**
	 * Assigns data to the default object.
	 * 
	 * XXX: why is this named reader2?
	 * 
	 * @param reader2
	 *            the reader for this answer
	 * @param correctAnswer
	 *            a correct answer
	 */
	public Hangman(DataReader reader2, String correctAnswer) {
		this.reader2 = reader2;
		this.correctAnswer = correctAnswer;
	}

	/**
	 * Checks the guessed word with the correct answer.
	 * 
	 * @return true in case the answer is correct and false otherwise
	 */
	public boolean play() {
		String data = reader2.readString();
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
		int numberUsedLetters = 0;
		Scanner scanner = null;
		String[] usedLetters = new String[50];
		// XXX: constant
		while (numberCorrectGuesses < wordToGuess.length() && numberWrongGuesses < 6) {
			System.out.println("Guess a letter: ");
			scanner = new Scanner(System.in);
			letter = scanner.nextLine();
			String pattern = "[^a-z]{1}";
			if (letter.matches(pattern)) {
				scanner.close();
				System.out.println("The character you entered is not in valid format!");
				return false;
			}
			for (int i = 0; i < numberUsedLetters; i++) {
				if (letter.equalsIgnoreCase(usedLetters[numberUsedLetters - 1])) {
					System.out
							.println("You're repeating letters. You're trying to cheat. You lost! ");
					scanner.close();
					return false;
				}
			}
			usedLetters[numberUsedLetters] = letter;
			numberUsedLetters++;
			letterSearcher(wordToGuess, letter);
		}
		if (numberCorrectGuesses == wordToGuess.length()) {
			System.out.println("You won! :)");
			return true;
		} else if (wordToGuess.length() == 0) {
			System.out.println("Enter some word!");
		} else {
			System.out.println("You lost! :(");
			return false;
		}
		scanner.close();
		return false;
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
		int counter = 0;
		int i = 0;
		int j = 0;
		do {
			i = line.indexOf(letterToCheck, j);
			if (i >= 0) {
				counter++;
				System.out.println("The letter is at " + i + " position.");
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
	 * XXX: main! Move to another class.
	 * 
	 * Plays with a word from the console input.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		new Hangman(new ConsoleDataReader(), wordToGuess).play();
		// Hangman hangman = new Hangman(new ConsoleDataReader(), "alabala");
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