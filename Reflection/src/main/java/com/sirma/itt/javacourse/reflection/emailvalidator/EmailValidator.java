package com.sirma.itt.javacourse.reflection.emailvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class EmailValidator contains a method for validating a string as an e-mail address.
 * 
 * @author Svetlosar Kovatchev
 */
public class EmailValidator {
	private static final String EMAIL_PATTERN = "^[a-zA-Z]{1}[a-zA-Z0-9-.]+@[a-zA-Z]{1}[a-zA-Z0-9-.]+\\.[a-zA-Z]{2,}$";
	private static final Pattern PATTERN = Pattern.compile(EMAIL_PATTERN);

	/**
	 * Validates a string as an e-mail address. The e-mail is supposed to begin with Latin letter
	 * followed by Latin letters, digits, signs '.' or '-'; Afterwards there should be "@" sign and
	 * again Latin letters, digits, signs '.' or '-'.
	 * 
	 * @param email
	 *            the string from the input
	 * @return the boolean result of the validation XXX: more appropriate name?
	 */
	public boolean validateEmail(String email) {
		Matcher result = PATTERN.matcher(email);
		return result.matches();
	}
}
