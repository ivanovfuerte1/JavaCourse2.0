package com.sirma.itt.javacourse.objects.heterogeneoustree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * This class tests the methods insert and inOrderToArray of the class HeterogeneousTreeTest.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class HeterogeneousTreeTest {

	/**
	 * Tests the methods insert and inOrderToArray with sample integer values.
	 */
	@Test
	public void testInsert() {
		HeterogeneousTree newTree = new HeterogeneousTree();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		newTree.printInOrder();
		String[] expectedResult = new String[] { "-7", "11", "13", "16", "17", "19", "23", "35" };
		String[] result = newTree.inOrderToArray((HeterogeneousTreeNode) newTree.getRoot());
		assertArrayEquals(expectedResult, result);
	}

	/**
	 * Tests the methods insert and inOrderToArray with sample string values.
	 */
	@Test
	public void testInsert2() {
		HeterogeneousTree newTree = new HeterogeneousTree();
		newTree.insert("b");
		newTree.insert("a");
		newTree.printInOrder();
		String[] expectedResult = new String[] { "a", "b" };
		String[] result = newTree.inOrderToArray((HeterogeneousTreeNode) newTree.getRoot());
		assertArrayEquals(expectedResult, result);
	}

	/**
	 * Tests the methods insert and inOrderToArray with sample values of different types.
	 */
	@Test
	public void testInsert3() {
		HeterogeneousTree newTree = new HeterogeneousTree();
		newTree.insert("b");
		newTree.insert(1);
		newTree.printInOrder();
		String[] expectedResult = new String[] { "1", "b" };
		String[] result = newTree.inOrderToArray((HeterogeneousTreeNode) newTree.getRoot());
		assertArrayEquals(expectedResult, result);
	}

	/**
	 * Tests the methods insert and inOrderToArray with sample values of different types.
	 * 
	 * @throws ParseException
	 *             if the date is not in valid format
	 */
	@Test
	public void testInsert4() throws ParseException {
		HeterogeneousTree newTree = new HeterogeneousTree();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String dateInString = "10/9/2014";
		Date dateOfCurrentVersion = sdf.parse(dateInString);
		newTree.insert("b");
		newTree.insert(1);
		newTree.insert(dateOfCurrentVersion);
		newTree.insert(126565.6845646844);
		newTree.printInOrder();
		String[] expectedResult = new String[] { "1", "126565.6845646844",
				"Wed Sep 10 00:00:00 EEST 2014", "b" };
		String[] result = newTree.inOrderToArray((HeterogeneousTreeNode) newTree.getRoot());
		assertArrayEquals(expectedResult, result);
	}

	/**
	 * Tests the methods insert and searchInOrder with correct value.
	 */
	@Test
	public void testSearchInOrder1() {
		HeterogeneousTree newTree = new HeterogeneousTree();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchInOrder(newTree.getRoot(), 19);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchInOrder with another correct value.
	 */
	@Test
	public void testSearchInOrder2() {
		HeterogeneousTree newTree = new HeterogeneousTree();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchInOrder(newTree.getRoot(), 17);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchInOrder with null value.
	 */
	@Test
	public void testSearchInOrder3() {
		HeterogeneousTree newTree = new HeterogeneousTree();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchInOrder(newTree.getRoot(), null);
		assertEquals(false, result);
	}

	/**
	 * Tests the methods insert and searchInOrder with negative correct value.
	 */
	@Test
	public void testSearchInOrder4() {
		HeterogeneousTree newTree = new HeterogeneousTree();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchInOrder(newTree.getRoot(), -7);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchInOrder with negative incorrect value.
	 */
	@Test
	public void testSearchInOrder5() {
		HeterogeneousTree newTree = new HeterogeneousTree();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchInOrder(newTree.getRoot(), -55);
		assertEquals(false, result);
	}

}
