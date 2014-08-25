package com.sirma.itt.javacourse.intro.randomstrings;

/**
 * The class RandomStrings contains methods for generating random strings with given length. Strings
 * may contain lowercase, uppercase and digits.
 * 
 * @author Svetlosar Kovatchev
 * @version 2.0
 */
public class RandomStrings {
	private static final char FIRST_UPPERCASE = 'A';
	private static final char FIRST_LOWERCASE = 'a';
	private static final char TOTAL_NUMBER_CHARACTERS = 62;
	private static final char TOTAL_NUMBER_LETTERS = 52;
	private static final char NUMBER_LETTERS_PER_CASE = 26;
	private static final char FIRST_DIGIT = 48;

	/**
	 * Generates a random string with given length. A random number is selected from the total
	 * number of permitted characters. Afterwards, according to this number is selected the type of
	 * the character - uppercase, lowercase or digit. Moreover, to the variable currentCharacter is
	 * assigned the representation of the letter or digit. Finally, the character is concatenated
	 * cyclically to empty or already generated part of the string until it reaches the given
	 * length.
	 * 
	 * @param length
	 *            the length of the string
	 * @return the generated string
	 */
	public String generateString(int length) {
		int baseLetterEachCase;
		char currentCharacter;
		int randomIndex;
		String output = "";

		for (int i = 0; i < length; i++) {
			randomIndex = (int) (Math.random() * TOTAL_NUMBER_CHARACTERS);
			if (randomIndex < TOTAL_NUMBER_LETTERS) {
				baseLetterEachCase = (randomIndex < NUMBER_LETTERS_PER_CASE) ? FIRST_UPPERCASE
						: FIRST_LOWERCASE;
				currentCharacter = (char) (baseLetterEachCase + randomIndex
						% NUMBER_LETTERS_PER_CASE);
			} else {
				currentCharacter = (char) (FIRST_DIGIT + randomIndex - TOTAL_NUMBER_LETTERS);
			}
			output = currentCharacter + output;
		}
		return output;
	}

}