package com.sirma.itt.javacourse.designpatterns.mail;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link MailTest} contains methods for testing the methods of the class {@link Mail}.
 */
public class MailTest {

	private static final String SAMPLE_ORIGIN = "Bulgaria";
	private static final String SAMPLE_DESTINATION = "South Africa";
	private static final String SAMPLE_SUBJECT = "Title";
	private static final String SAMPLE_CONTENT = "Some text";
	private static final String[] SAMPLE_CC = new String[] { "Other destination",
			"Other destination" };
	private static final Object[] SAMPLE_ATTACHMENTS = new Object[] { "First attachment", 6, false };

	/**
	 * Tests the methods for attaching and getting the destination of the mail.
	 */
	@Test
	public void testDestination() {
		Mail mail = new Mail(SAMPLE_ORIGIN);
		String result = mail.attachFrom(SAMPLE_DESTINATION).attachFrom(SAMPLE_ORIGIN)
				.attachTo(SAMPLE_DESTINATION).attachSubject(SAMPLE_SUBJECT)
				.attachContent(SAMPLE_CONTENT).attachCC(SAMPLE_CC)
				.attachAttachments(SAMPLE_ATTACHMENTS).getTo();
		String expected = "South Africa";
		assertEquals(expected, result);
	}

	/**
	 * Tests the methods for attaching and getting the subject of the mail.
	 */
	@Test
	public void testSubject() {
		Mail mail = new Mail(SAMPLE_ORIGIN);
		String result = mail.attachFrom(SAMPLE_DESTINATION).attachFrom(SAMPLE_ORIGIN)
				.attachTo(SAMPLE_DESTINATION).attachSubject(SAMPLE_SUBJECT)
				.attachContent(SAMPLE_CONTENT).attachCC(SAMPLE_CC)
				.attachAttachments(SAMPLE_ATTACHMENTS).getSubject();
		String expected = "Title";
		assertEquals(expected, result);
	}

	/**
	 * Tests the methods for attaching and getting the content of the mail.
	 */
	@Test
	public void testContent() {
		Mail mail = new Mail(SAMPLE_ORIGIN);
		String result = mail.attachFrom(SAMPLE_DESTINATION).attachFrom(SAMPLE_ORIGIN)
				.attachTo(SAMPLE_DESTINATION).attachSubject(SAMPLE_SUBJECT)
				.attachContent(SAMPLE_CONTENT).attachCC(SAMPLE_CC)
				.attachAttachments(SAMPLE_ATTACHMENTS).getContent();
		String expected = "Some text";
		assertEquals(expected, result);
	}

}
