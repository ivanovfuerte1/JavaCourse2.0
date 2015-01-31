package com.sirma.itt.javacourse.common;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * The class {@link JTextFieldLimit} contains a method for limiting the length of some text.
 */
public class JTextFieldLimit extends PlainDocument {
	private static final long serialVersionUID = 535430009029745466L;
	private int limit;

	/**
	 * Constructs an object of {@link JTextFieldLimit} assigning value to its variable for length of
	 * the text.
	 * 
	 * @param limit
	 *            the length of the text permitted for the current text field
	 */
	public JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}

	/**
	 * Getter method for limit.
	 *
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}
}
