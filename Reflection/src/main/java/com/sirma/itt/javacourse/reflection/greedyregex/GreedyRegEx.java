package com.sirma.itt.javacourse.reflection.greedyregex;

/**
 * The class {@link GreedyRegEx} contains a method <br>
 * for replacing data surrounded in '&#60;x>' and '&#60;/x>' with '&#60;x/>'.
 * 
 * @author Svetlosar Kovatchev
 */
public final class GreedyRegEx {

	private static final String REGEX_TO_REPLACE = "<x>\\w*\\s*\\w*</x>";
	private static final String REPLACE = "<x/>";

	/**
	 * Replaces data surrounded in '&#60;x>' and '&#60;/x>' with '&#60;x/>'.
	 * 
	 * @param input
	 *            at
	 * @return the modified string
	 */
	public String replaceTags(String input) {
		String output = input.replaceAll(REGEX_TO_REPLACE, REPLACE);
		return output;
	}

}
