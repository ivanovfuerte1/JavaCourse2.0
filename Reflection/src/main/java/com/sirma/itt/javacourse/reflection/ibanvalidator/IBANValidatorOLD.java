package com.sirma.itt.javacourse.reflection.ibanvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class IBANValidator contains a method for replacing the first part of valid Bulgarian IBAN
 * with '****'.
 * 
 * @author Svetlosar Kovatchev
 */
public class IBANValidatorOLD {
	private static final String REGEX_TO_REPLACE = "(BG(\\w{2})\\s(\\w{2})BG)((\\s(\\d{4})){3}\\s)";
	private static final String REPLACE = "****";

	/**
	 * Replaces the first part of valid Bulgarian IBAN with '****'.
	 * 
	 * @param input
	 *            the user input containing the full IBAN
	 * @return the resulting string
	 */
	public String replaceIBAN(String input) {
		// System.out.println();
		// System.out.println(input);

		// another way to solve the task
		Pattern patternToReplace = Pattern.compile(REGEX_TO_REPLACE);
		Matcher matcherToReplace = patternToReplace.matcher(input);
		StringBuffer sb = new StringBuffer();
		while (matcherToReplace.find()) {
			matcherToReplace.appendReplacement(sb, REPLACE);
		}
		matcherToReplace.appendTail(sb);

		// System.out.println(sb.toString());

		return sb.toString();
	}

}