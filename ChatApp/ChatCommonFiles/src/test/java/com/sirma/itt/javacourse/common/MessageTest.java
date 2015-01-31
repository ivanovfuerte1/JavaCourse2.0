package com.sirma.itt.javacourse.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link MessageTest} test the methods of the {@link Message} class.
 */
public class MessageTest {

	/**
	 * Tests the methods setMessageContents and getMessageContents with sample value.
	 */
	@Test
	public void testMessageContents() {
		String expected = "Some message";
		Message message = new Message();
		message.setMessageContents("Some message");
		String actual = message.getMessageContents();
		assertEquals(expected, actual);
	}

	/**
	 * Tests the methods setNickname and getNickname with sample value.
	 */
	@Test
	public void testNickname() {
		String expected = "Some nickname";
		Message message = new Message();
		message.setNickname("Some nickname");
		String actual = message.getNickname();
		assertEquals(expected, actual);
	}

	/**
	 * Tests the methods setType and getType with sample value.
	 */
	@Test
	public void testType() {
		String expected = "Some type";
		Message message = new Message("", "");
		message.setType("Some type");
		String actual = message.getType();
		assertEquals(expected, actual);
	}

}
