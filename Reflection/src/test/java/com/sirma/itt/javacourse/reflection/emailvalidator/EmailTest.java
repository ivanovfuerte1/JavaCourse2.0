package com.sirma.itt.javacourse.reflection.emailvalidator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link EmailTest} contains tests for the method emailValidator of the class
 * {@link EmailValidator}.
 * 
 * @author Svetlosar Kovatchev
 */
public class EmailTest {

	/**
	 * Tests the method emailValidator with a valid e-mail.
	 */
	@Test
	public void test1() {
		String input = "test.t-s@sir-ma.com";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(true, isValid);
	}

	/**
	 * Tests the method emailValidator with a valid e-mail.
	 */
	@Test
	public void test2() {
		String input = "h1ello@sirma999.com";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(true, isValid);
	}

	/**
	 * Tests the method emailValidator with a valid e-mail.
	 */
	@Test
	public void test3() {
		String input = "test@sirma.com";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(true, isValid);
	}

	/**
	 * Tests the method emailValidator with a valid e-mail.
	 */
	@Test
	public void test4() {
		String input = "eee@s-sirma.com";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(true, isValid);
	}

	/**
	 * Tests the method emailValidator with a valid e-mail.
	 */
	@Test
	public void test5() {
		String input = "eee@cc.british.museum";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(true, isValid);
	}

	/**
	 * Tests the method emailValidator with an incorrect e-mail.
	 */
	@Test
	public void test6() {
		String input = "t.@aa";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(false, isValid);
	}

	/**
	 * Tests the method emailValidator with an incorrect e-mail.
	 */
	@Test
	public void test7() {
		String input = "Z.ad-w@sthg----.....";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(false, isValid);
	}

	/**
	 * Tests the method emailValidator with an incorrect e-mail.
	 */
	@Test
	public void test8() {
		String input = "ee@ZZZZZZZ";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(false, isValid);
	}

	/**
	 * Tests the method emailValidator with an incorrect e-mail.
	 */
	@Test
	public void test9() {
		String input = "Z";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(false, isValid);
	}

	/**
	 * Tests the method emailValidator with an incorrect e-mail.
	 */
	@Test
	public void test10() {
		String input = "";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(false, isValid);
	}

	/**
	 * Tests the method emailValidator with an incorrect e-mail.
	 */
	@Test
	public void test11() {
		String input = "eee@cc.british.mu*seum";
		boolean isValid = new EmailValidator().validateEmail(input);
		assertEquals(false, isValid);
	}

	/**
	 * Tests the method emailValidator with an incorrect e-mail.
	 */
	@Test
	public void test12() {
		String input = "1.@s";
		boolean isValid = new EmailValidator().validateEmail(input);
		System.out.println("[0-9]");
		assertEquals(false, isValid);
	}

}
