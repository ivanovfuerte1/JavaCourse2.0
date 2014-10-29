package com.sirma.itt.javacourse.reflection.greedyregex;

// JAVADOC MUST BE IMPROVED
/**
 * XXX: ??
 * 
 * A warning about usage of HTML tags is being ignored.
 */
@SuppressWarnings("javadoc")
/**
 * The class {@link GreedyRegEx} contains a method <br> for replacing data surrounded in '<x>' and '</x>'
 * with '<x/>'.
 * 
 * @author Svetlosar Kovatchev
 */
public final class GreedyRegEx {

	private static final String REGEX_TO_REPLACE = "<x>\\w*\\s*\\w*</x>";
	private static final String REPLACE = "<x/>";

	/**
	 * Replaces data surrounded in '<x>' and '</x>' with '<x/>'.
	 */
	/**
	 * @param input
	 *            at
	 * @return the modified string
	 */
	public String replaceTags(String input) {
		String output = input.replaceAll(REGEX_TO_REPLACE, REPLACE);
		return output;
	}

}
