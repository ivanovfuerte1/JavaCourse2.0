package com.sirma.itt.javacourse.common;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The class {@link Language} contains method for setting the locale and getting the messages for
 * the chosen locale.
 */
public final class Language {
	private static Locale currentLocale = new Locale("en", "US");
	private static ResourceBundle messages = ResourceBundle.getBundle("ChatBundle", currentLocale);

	/**
	 * Constructs instance of the class.
	 */
	private Language() {
	}

	/**
	 * Sets a locale for the messages to return.
	 * 
	 * @param chosenLocale
	 *            the locale chosen for the messages to return
	 */
	public static void setLocale(Locale chosenLocale) {
		synchronized (messages) {
			Language.currentLocale = chosenLocale;
			messages = ResourceBundle.getBundle("ChatBundle", currentLocale);
		}
	}

	/**
	 * Returns the messages for the chosen locale.
	 * 
	 * @return the messages for the chosen locale
	 */
	public static ResourceBundle getMessages() {
		return messages;
	}
}
