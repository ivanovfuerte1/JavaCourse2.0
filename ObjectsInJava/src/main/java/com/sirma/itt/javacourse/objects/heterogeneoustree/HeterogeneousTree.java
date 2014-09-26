package com.sirma.itt.javacourse.objects.heterogeneoustree;

import java.util.ArrayList;
import java.util.List;

/**
 * The class HeterogeneousTree contains methods for inserting nodes, printing elements and searching
 * for an element in a heterogeneous tree.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class HeterogeneousTree {
	private HeterogeneousTreeNode root;
	private List<String> stringCollection = new ArrayList<String>();
	private boolean found = false;

	/**
	 * Constructs the tree.
	 */
	public HeterogeneousTree() {
		this.setRoot(null);
	}

	/**
	 * Inserts new value in the heterogeneous tree.
	 * 
	 * @param value
	 *            the value to be inserted
	 */
	public void insert(Object value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.setRoot(insert(value, getRoot()));
	}

	/**
	 * Inserts node in the heterogeneous tree by given value.
	 * 
	 * @param value
	 *            the new value
	 * @param primaryNode
	 *            current node
	 * @return the inserted node
	 */
	private HeterogeneousTreeNode insert(Object value, HeterogeneousTreeNode primaryNode) {
		HeterogeneousTreeNode node = primaryNode;
		if (node == null) {
			node = new HeterogeneousTreeNode(value);
		} else {
			int compareTo = value.toString().compareTo(node.getValue().toString());
			if (compareTo < 0) {
				node.setLeftChild(insert(value, node.getLeftChild()));
			} else if (compareTo > 0) {
				node.setRightChild(insert(value, node.getRightChild()));
			} else {
				System.out.println("The number " + value + " already exists.");
			}
		}
		return node;
	}

	/**
	 * Searches for a value in a heterogeneous tree in pre-order manner.
	 * 
	 * @param root
	 *            the root of the heterogeneous tree to be traversed
	 * @param value
	 *            the value to search for
	 * @return the boolean result of the search
	 */
	public boolean searchPreOrder(HeterogeneousTreeNode root, Object value) {
		if (root != null) {
			if (value == root.getValue()) {
				System.out.println("There is an element with the value " + root.getValue()
						+ " in the tree.");
				found = true;
			}
		}
		if (root == null) {
			return found;
		}
		searchPreOrder(root.getLeftChild(), value);
		searchPreOrder(root.getRightChild(), value);
		return found;
	}

	/**
	 * Traverses the heterogeneous tree in in-order manner.
	 * 
	 * @param root
	 *            - the heterogeneous tree to be traversed.
	 */
	private void inOrder(HeterogeneousTreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeftChild());
		System.out.print(root.getValue() + " ");
		stringCollection.add(root.getValue().toString());
		inOrder(root.getRightChild());
	}

	/**
	 * Traverses heterogeneous tree in in-order manner and returns its values in a sorted array.
	 * 
	 * @param root
	 *            - the heterogeneous tree to be traversed.
	 * @return the tree to sorted array
	 */
	public String[] inOrderToArray(HeterogeneousTreeNode root) {

		String[] array1 = new String[stringCollection.size()];

		int i = 0;
		for (String s : stringCollection) {
			array1[i] = s;
			i++;
		}
		return array1;
	}

	/**
	 * Traverses and prints the heterogeneous tree in in-order manner.
	 */
	public void printInOrder() {
		inOrder(this.getRoot());
		System.out.println();
	}

	/**
	 * Returns the root of the tree.
	 * 
	 * @return the root of the tree
	 */
	public HeterogeneousTreeNode getRoot() {
		return root;
	}

	/**
	 * Sets a root of the tree.
	 * 
	 * @param root
	 *            the root to be set
	 */
	private void setRoot(HeterogeneousTreeNode root) {
		this.root = root;
	}

}
