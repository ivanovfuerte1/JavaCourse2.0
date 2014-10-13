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

}
