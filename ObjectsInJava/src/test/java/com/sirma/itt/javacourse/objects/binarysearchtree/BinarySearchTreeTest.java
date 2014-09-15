package com.sirma.itt.javacourse.objects.binarysearchtree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class tests the methods insert and inOrderToArray of the class BinarySearchTree.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class BinarySearchTreeTest {

	/**
	 * Tests the methods insert and inOrderToArray with sample values.
	 */
	@Test
	public void testInsert() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
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
		String[] result = newTree.inOrderToArray((BinaryTreeNode<Integer>) newTree.getRoot());
		assertArrayEquals(expectedResult, result);
	}

	/**
	 * Tests the methods insert and preOrderToArray with sample values.
	 */
	@Test
	public void testInsert2() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		newTree.printPreOrder();
		String[] expectedResult = new String[] { "19", "11", "-7", "16", "13", "17", "35", "23" };
		String[] result = newTree.preOrderToArray((BinaryTreeNode<Integer>) newTree.getRoot());
		assertArrayEquals(expectedResult, result);
	}

	/**
	 * Tests the methods insert and preOrderToArray with sample values.
	 */
	@Test
	public void testInsert3() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		newTree.printPostOrder();
		String[] expectedResult = new String[] { "-7", "13", "17", "16", "11", "23", "35", "19" };
		String[] result = newTree.postOrderToArray((BinaryTreeNode<Integer>) newTree.getRoot());
		assertArrayEquals(expectedResult, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with correct value.
	 */
	@Test
	public void testSearchPreOrder1() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), 19);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with incorrect value.
	 */
	@Test
	public void testSearchPreOrder2() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), 55);
		assertEquals(false, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with null value.
	 */
	@Test
	public void testSearchPreOrder3() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), null);
		assertEquals(false, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with zero value.
	 */
	@Test
	public void testSearchPreOrder4() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), 0);
		assertEquals(false, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with correct value.
	 */
	@Test
	public void testSearchPreOrder5() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), 11);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with correct value.
	 */
	@Test
	public void testSearchPreOrder6() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), 35);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with correct value.
	 */
	@Test
	public void testSearchPreOrder7() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), -7);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with correct value.
	 */
	@Test
	public void testSearchPreOrder8() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), 16);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with correct value.
	 */
	@Test
	public void testSearchPreOrder9() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), 23);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with correct value.
	 */
	@Test
	public void testSearchPreOrder10() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), 13);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPreOrder with correct value.
	 */
	@Test
	public void testSearchPreOrder11() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPreOrder(newTree.getRoot(), 17);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchInOrder with negative incorrect value.
	 */
	@Test
	public void testSearchInOrder() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchInOrder(newTree.getRoot(), -22);
		assertEquals(false, result);
	}

	/**
	 * Tests the methods insert and searchInOrder with correct value.
	 */
	@Test
	public void testSearchInOrder2() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchInOrder(newTree.getRoot(), 11);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchInOrder with correct value.
	 */
	@Test
	public void testSearchInOrder3() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
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
	 * Tests the methods insert and searchInOrder with correct value.
	 */
	@Test
	public void testSearchInOrder4() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchInOrder(newTree.getRoot(), 35);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchInOrder with correct value.
	 */
	@Test
	public void testSearchInOrder5() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchInOrder(newTree.getRoot(), 23);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPostOrder with negative incorrect value.
	 */
	@Test
	public void testSearchPostOrder() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPostOrder(newTree.getRoot(), -22);
		assertEquals(false, result);
	}

	/**
	 * Tests the methods insert and searchPostOrder with correct value.
	 */
	@Test
	public void testSearchPostOrder2() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPostOrder(newTree.getRoot(), 11);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPostOrder with correct value.
	 */
	@Test
	public void testSearchPostOrder3() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPostOrder(newTree.getRoot(), 19);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPostOrder with correct value.
	 */
	@Test
	public void testSearchPostOrder4() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPostOrder(newTree.getRoot(), 35);
		assertEquals(true, result);
	}

	/**
	 * Tests the methods insert and searchPostOrder with correct value.
	 */
	@Test
	public void testSearchPostOrder5() {
		BinarySearchTree<Integer> newTree = new BinarySearchTree<Integer>();
		newTree.insert(19);
		newTree.insert(11);
		newTree.insert(35);
		newTree.insert(-7);
		newTree.insert(16);
		newTree.insert(23);
		newTree.insert(13);
		newTree.insert(17);
		boolean result = newTree.searchPostOrder(newTree.getRoot(), 23);
		assertEquals(true, result);
	}

}
