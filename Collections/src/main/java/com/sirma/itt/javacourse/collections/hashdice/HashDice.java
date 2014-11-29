package com.sirma.itt.javacourse.collections.hashdice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link HashDice} contains methods for generating a statistic containing combinations of
 * integers representing the result of two dice thrown and printing it.
 * 
 * @author Svetlosar Kovatchev
 */
public class HashDice {
	private static final Logger LOGGER = LogManager.getLogger(HashDice.class);
	private int sidesNumber;
	private int numberOfThrows;
	private DataReader data;
	private static final int DEFAULT_NUMBER_OF_SIDES = 6;

	/**
	 * Constructs an object by assigning values for its number of sides of the die, number of throws
	 * and data of combinations from different source.
	 * 
	 * @param sidesNumber
	 *            the number of sides of the die
	 * @param numberOfThrows
	 *            the number of throws
	 * @param data
	 *            the data of combinations from different source
	 */
	public HashDice(int sidesNumber, int numberOfThrows, DataReader data) {
		this.sidesNumber = sidesNumber;
		this.numberOfThrows = numberOfThrows;
		this.data = data;
	}

	/**
	 * Constructs an object by assigning values for its number of throws and data of combinations
	 * from different source. A default number of sides is assigned.
	 * 
	 * @param numberOfThrows
	 *            the number of throws
	 * @param data
	 *            the data of combinations from different source
	 */
	public HashDice(int numberOfThrows, DataReader data) {
		this.sidesNumber = DEFAULT_NUMBER_OF_SIDES;
		this.numberOfThrows = numberOfThrows;
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
		Map<String, Set<Integer>> combinations = new HashMap<>();
		for (int throwNumber = 0; throwNumber < numberOfThrows; throwNumber++) {
			String currentCombination = data.getCombination(sidesNumber);
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
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Combination: '").append(currentCombination.getKey())
					.append("' Throw number: ").append(currentCombination.getValue().toString());
			LOGGER.info(stringBuilder);
		}
	}

}
