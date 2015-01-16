package com.sirma.itt.javacourse.chat.client;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
	private static Locale currentLocale = new Locale("en", "US");
	private static ResourceBundle messages = ResourceBundle.getBundle("ChatBundle", currentLocale);

	/**
	 * Constructs instance of the class.
	 */
	private Language() {
	}

	public static void setLocale(Locale chosenLocale) {
		synchronized (messages) {
			Language.currentLocale = chosenLocale;
			messages = ResourceBundle.getBundle("ChatBundle", currentLocale);
		}
	}

	public static ResourceBundle getMessages() {
		return messages;
	}
}
