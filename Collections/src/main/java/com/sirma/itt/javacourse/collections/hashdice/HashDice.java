package com.sirma.itt.javacourse.collections.hashdice;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * The class {@link HashDice} contains methods for generating a statistic containing combinations of
 * integers representing the result of two dice thrown and printing it.
 * 
 * @author Svetlosar Kovatchev
 */
public class HashDice {
	private int m;
	private int n;
	private DataReader data;

	/**
	 * Constructs an object by assigning values for its number of sides of the die, number of throws
	 * and data of combinations from different source.
	 * 
	 * @param m
	 *            the number of sides of the die
	 * @param n
	 *            the number of throws
	 * @param data
	 *            the data of combinations from different source
	 */
	public HashDice(int m, int n, DataReader data) {
		this.m = m;
		this.n = n;
		this.data = data;
	}

	/**
	 * Generates a statistic containing combinations of integers representing the result of two dice
	 * thrown and the throw number each one occurred.
	 * 
	 * @return combinations of integers representing the result of two dice thrown and the throw
	 *         number each one occurred
	 */
	public Map<String, Set<Integer>> combinationsCreator() {
		Map<String, Set<Integer>> combinations = new TreeMap<>();
		Integer throwNumber = 0;
		for (int i = 0; i < n; i++) {
			throwNumber++;
			String currentCombination = data.getCombination(m);
			if (combinations.containsKey(currentCombination)) {
				Set<Integer> temp = combinations.get(currentCombination);
				temp.add(throwNumber);
			} else {
				Set<Integer> throwNumbers = new HashSet<>();
				throwNumbers.add(throwNumber);
				combinations.put(currentCombination, throwNumbers);
			}
		}
		return combinations;
	}

	/**
	 * Prints the statistic containing combinations of integers representing the result of two dice
	 * thrown and the throw number each one occurred.
	 * 
	 * @param combinationsCount
	 *            the statistic containing combinations of integers representing the result of two
	 *            dice thrown and the throw number each one occurred.
	 */
	public void printStatistics(Map<String, Set<Integer>> combinationsCount) {
		for (Entry<String, Set<Integer>> currentCombination : combinationsCount.entrySet()) {
			System.out.format("Combination: '%s' Throw number: %s %n", currentCombination.getKey(),
					currentCombination.getValue().toString());
		}
	}

}
