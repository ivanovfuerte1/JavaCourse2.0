package com.sirma.itt.javacourse.collections.hashdice;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/**
 * The class {@link HashDiceTest} contains a test for the method combinationsCreator of the class
 * {@link HashDice}.
 * 
 * @author Svetlosar Kovatchev
 */
public class HashDiceTest {

	private String[] input = { "6,6", "1,2", "6,6" };

	/**
	 * Tests the method combinationsCreator of the class {@link HashDice} with a sample string.
	 */
	@Test
	public void test() {
		HashDice hashDice = new HashDice(3, 3, new TestReader(input));
		Map<String, Set<Integer>> result = hashDice.combinationsCreator();
		Map<String, Set<Integer>> expected = new TreeMap<>();
		Set<Integer> firstThrow = new HashSet<Integer>();
		firstThrow.add(2);
		expected.put(input[1], firstThrow);
		Set<Integer> secondThrow = new HashSet<Integer>();
		secondThrow.add(3);
		secondThrow.add(1);
		expected.put(input[0], secondThrow);
		assertEquals(expected, result);
	}

}
