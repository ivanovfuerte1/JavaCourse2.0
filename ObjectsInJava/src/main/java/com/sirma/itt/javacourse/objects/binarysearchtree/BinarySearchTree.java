package com.sirma.itt.javacourse.objects.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * The class BinarySearchTree contains methods for inserting nodes, printing elements and searching
 * for an element in a binary tree.
 * 
 * @param <T>
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<T>> {
	/**
	 * The root of the tree.
	 */
	private BinaryTreeNode<T> root;
	private List<String> stringCollection = new ArrayList<String>();
	private boolean found = false;

	/**
	 * Constructs the tree.
	 */
	public BinarySearchTree() {
		this.setRoot(null);
		this.stringCollection.add("");
	}

	/**
	 * Inserts new value in the binary search tree.
	 * 
	 * @param value
	 *            the value to be inserted.
	 */
	public void insert(T value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.setRoot(insert(value, null, getRoot()));
	}

	/**
	 * Inserts node in the binary search tree by given value.
	 * 
	 * @param value
	 *            the new value.
	 * @param parentNode
	 *            the parent of the new node.
	 * @param node
	 *            the current node.
	 * @return the inserted node
	 */
	private BinaryTreeNode<T> insert(T value, BinaryTreeNode<T> parentNode, BinaryTreeNode<T> node) {
		if (node == null) {
			node = new BinaryTreeNode<T>(value);
			node.setParent(parentNode);

			if (parentNode != null) {
			}
		} else {
			int compareTo = value.compareTo(node.getValue());
			if (compareTo < 0) {
				node.setLeftChild(insert(value, node, node.getLeftChild()));
			} else if (compareTo > 0) {
				node.setRightChild(insert(value, node, node.getRightChild()));
			} else {
				System.out.println("The number " + value + " already exists.");
			}
		}
		return node;
	}

	/**
	 * Searches for a value in a binary tree and returns a boolean result of the search.
	 * 
	 * @param root
	 *            the root of the binary tree to be traversed
	 * @param value
	 *            the value to check for
	 * @return the boolean result of the search
	 */
	public boolean searchInOrder(BinaryTreeNode<T> root, T value) {
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
		searchInOrder(root.getLeftChild(), value);
		searchInOrder(root.getRightChild(), value);
		return found;
	}

	/**
	 * Traverses binary tree in in-order manner.
	 * 
	 * @param root
	 *            - the binary tree to be traversed.
	 */
	private void inOrder(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeftChild());
		System.out.print(root.getValue() + " ");
		stringCollection.add(root.getValue().toString());
		inOrder(root.getRightChild());
	}

	/**
	 * Traverses binary tree in in-order manner.
	 * 
	 * @param root
	 *            - the binary tree to be traversed.
	 * @return the tree to sorted array
	 */
	public String[] inOrderToArray(BinaryTreeNode<T> root) {

		String[] array1 = new String[stringCollection.size() - 1];

		int i = 0;
		for (String s : stringCollection) {
			if (i == 0) {
				i++;
				continue;
			}
			array1[--i] = s;
			i += 2;
		}
		return array1;
	}

	/**
	 * Traverses and prints the binary tree in in-order manner.
	 */
	public void printInOrder() {
		inOrder(this.getRoot());
		System.out.println();
	}

	/**
	 * Gets the root of the tree.
	 * 
	 * @return the root of the tree
	 */
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Sets a root of the tree.
	 * 
	 * @param root
	 *            the root to be set
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

}
