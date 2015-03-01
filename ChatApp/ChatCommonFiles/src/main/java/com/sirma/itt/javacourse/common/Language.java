package com.sirma.itt.javacourse.common;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The class {@link Language} contains method for setting the locale and getting the messages for
 * the chosen locale.
 */
public final class Language {
	private static Locale currentLocale = new Locale(ConstantsChat.EN, ConstantsChat.US);
	private static ResourceBundle translation = ResourceBundle.getBundle(ConstantsChat.CHAT_BUNDLE,
			currentLocale);

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
		synchronized (translation) {
			Language.currentLocale = chosenLocale;
			translation = ResourceBundle.getBundle(ConstantsChat.CHAT_BUNDLE, currentLocale);
		}
	}

	/**
	 * Returns the messages for the chosen locale.
	 * 
	 * @return the messages for the chosen locale
	 */
	public static ResourceBundle getTranslation() {
		return translation;
	}
}
