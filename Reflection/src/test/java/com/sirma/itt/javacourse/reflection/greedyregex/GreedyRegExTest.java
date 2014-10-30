package com.sirma.itt.javacourse.reflection.greedyregex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The class {@link GreedyRegExTest} contains a test for the method replaceTags of the class
 * {@link GreedyRegEx}.
 * 
 * @author Svetlosar Kovatchev
 */
public class GreedyRegExTest {

	/**
	 * Tests the method replaceTags of the class {@link GreedyRegEx} with given code.
	 */
	@Test
	public void test1() {
		String input = "<x><b></b><x>Hello world</x>\n<b>sdfsdf</b><x>Good\nmorning</x><x>69</x><x>sdfsdfsdf</x>\n</x>";
		String result = new GreedyRegEx().replaceTags(input);
		assertEquals("<x><b></b><x/>\n<b>sdfsdf</b><x/><x/><x/>\n</x>", result);
	}

	/**
	 * Tests the method replaceTags of the class {@link GreedyRegEx} with given code.
	 */
	@Test
	public void test2() {
		final String newLine = System.lineSeparator();
		StringBuilder input = new StringBuilder();
		input.append("<x><b></b><x>Hello world</x>");
		input.append(newLine);
		input.append("<b>sdfsdf</b><x>Good");
		input.append(newLine);
		input.append("morning</x><x>69</x><x>sdfsdfsdf</x>");
		input.append(newLine);
		input.append("</x>");
		String stringInput = input.toString();
		String result = new GreedyRegEx().replaceTags(stringInput);

		StringBuilder output = new StringBuilder();
		output.append("<x><b></b><x/>");
		output.append(newLine);
		output.append("<b>sdfsdf</b><x/><x/><x/>");
		output.append(newLine);
		output.append("</x>");
		String expected = output.toString();
		assertEquals(expected, result);
	}

	/**
	 * Tests the method replaceTags of the class {@link GreedyRegEx} replacing tags only.
	 */
	@Test
	public void test3() {
		final String newLine = System.lineSeparator();
		StringBuilder input = new StringBuilder();
		input.append("<x><b></b><x></x>");
		input.append(newLine);
		input.append("</x>");
		String stringInput = input.toString();
		String result = new GreedyRegEx().replaceTags(stringInput);

		StringBuilder output = new StringBuilder();
		output.append("<x><b></b><x/>");
		output.append(newLine);
		output.append("</x>");
		String expected = output.toString();
		assertEquals(expected, result);
	}

	/**
	 * Tests the method replaceTags of the class {@link GreedyRegEx} replacing spaces.
	 */
	@Test
	public void test4() {
		StringBuilder input = new StringBuilder();
		input.append("<x><b></b><x>   </x></x>");
		String stringInput = input.toString();
		String result = new GreedyRegEx().replaceTags(stringInput);

		StringBuilder output = new StringBuilder();
		output.append("<x><b></b><x/></x>");
		String expected = output.toString();
		assertEquals(expected, result);
	}

	/**
	 * Tests the method replaceTags of the class {@link GreedyRegEx} replacing spaces before text.
	 */
	@Test
	public void test5() {
		StringBuilder input = new StringBuilder();
		input.append("<x><b></b><x>   sxhsrh</x></x>");
		String stringInput = input.toString();
		String result = new GreedyRegEx().replaceTags(stringInput);

		StringBuilder output = new StringBuilder();
		output.append("<x><b></b><x/></x>");
		String expected = output.toString();
		assertEquals(expected, result);
	}

}
