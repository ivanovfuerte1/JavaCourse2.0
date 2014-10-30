package com.sirma.itt.javacourse.reflection.ibanvalidator;

import java.util.regex.Pattern;

/**
 * The class IBANValidator contains a method for replacing the first part of valid Bulgarian IBAN
 * with '****'.
 * 
 * @author Svetlosar Kovatchev
 */
public class IBANValidator {
	private static final String REGEX_TO_REPLACE = "(BG(\\w{2})\\s(\\w{2})BG)((\\s(\\d{4})){3}\\s)";
	private static final String REPLACE = "****";
	private static final Pattern PATTERN = Pattern.compile(REGEX_TO_REPLACE);

	/**
	 * Replaces the first part of valid Bulgarian IBAN with '****'.
	 * 
	 * @param input
	 *            the user input containing the full IBAN
	 * @return the resulting string
	 */
	public String replaceIBAN(String input) {
		return PATTERN.matcher(input).replaceAll(REPLACE);
	}

}
