package com.sirma.itt.javacourse.objects.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/**
 * The class BinarySearchTree contains methods for inserting nodes, printing elements and searching
 * for an element in a binary tree.
 * 
 * @param <T>
 *            can be any comparable type
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class BinarySearchTree<T extends Comparable<T>> {
	private BinaryTreeNode<T> root;
	private boolean found = false;
	private List<String> inOrderCollection = new ArrayList<String>();
	private List<String> preOrderCollection = new ArrayList<String>();
	private List<String> postOrderCollection = new ArrayList<String>();

	/**
	 * Constructs the tree.
	 */
	public BinarySearchTree() {
		this.setRoot(null);
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
		this.setRoot(insert(value, getRoot()));
	}

	/**
	 * Inserts node in the binary search tree by given value.
	 * 
	 * @param value
	 *            the new value.
	 * @param primaryNode
	 *            the current node.
	 * @return the inserted node
	 */
	private BinaryTreeNode<T> insert(T value, BinaryTreeNode<T> primaryNode) {
		BinaryTreeNode<T> node = primaryNode;
		if (node == null) {
			node = new BinaryTreeNode<T>(value);
		} else {
			int compareTo = value.compareTo(node.getValue());
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
	 * Searches for a value in a binary tree in pre-order manner and returns a boolean result of the
	 * search.
	 * 
	 * @param root
	 *            the root of the binary tree to be traversed
	 * @param value
	 *            the value to check for
	 * @return the boolean result of the search
	 */
	public boolean searchPreOrder(BinaryTreeNode<T> root, T value) {
		if (root != null) {
			if (value == root.getValue()) {
				System.out.println("There is an element with the value " + root.getValue()
						+ " in the tree.");
				found = true;
				return found;
			}
		} else
			return found;
		searchPreOrder(root.getLeftChild(), value);
		searchPreOrder(root.getRightChild(), value);
		return found;
	}

	/**
	 * Searches for a value in a binary tree in in-order manner and returns a boolean result of the
	 * search.
	 * 
	 * @param root
	 *            the root of the binary tree to be traversed
	 * @param value
	 *            the value to check for
	 * @return the boolean result of the search
	 */
	public boolean searchInOrder(BinaryTreeNode<T> root, T value) {
		if (root != null) {
			searchInOrder(root.getLeftChild(), value);
			if (value == root.getValue()) {
				System.out.println("There is an element with the value " + root.getValue()
						+ " in the tree.");
				found = true;
				return found;
			}
			searchInOrder(root.getRightChild(), value);
		}
		return found;
	}

	/**
	 * Searches for a value in a binary tree in post-order manner and returns a boolean result of
	 * the search.
	 * 
	 * @param root
	 *            the root of the binary tree to be traversed
	 * @param value
	 *            the value to check for
	 * @return the boolean result of the search
	 */
	public boolean searchPostOrder(BinaryTreeNode<T> root, T value) {
		if (root != null) {
			searchPostOrder(root.getLeftChild(), value);
			searchPostOrder(root.getRightChild(), value);
			if (value == root.getValue()) {
				System.out.println("There is an element with the value " + root.getValue()
						+ " in the tree.");
				found = true;
				return found;
			}
		}
		return found;
	}

	/**
	 * Traverses binary tree in in-order manner.
	 * 
	 * @param root
	 *            - the binary tree to be traversed.
	 */
	private void traverseInOrder(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}
		traverseInOrder(root.getLeftChild());
		System.out.print(root.getValue() + " ");
		inOrderCollection.add(root.getValue().toString());
		traverseInOrder(root.getRightChild());
	}

	/**
	 * Traverses binary tree in in-order manner.
	 * 
	 * @param root
	 *            - the binary tree to be traversed.
	 * @return the tree to sorted array
	 */
	public String[] inOrderToArray(BinaryTreeNode<T> root) {
		String[] array1 = new String[inOrderCollection.size()];

		int i = 0;
		for (String s : inOrderCollection) {
			array1[i] = s;
			i++;
		}
		return array1;
	}

	/**
	 * Traverses and prints the binary tree in in-order manner.
	 */
	public void printInOrder() {
		traverseInOrder(this.getRoot());
		System.out.println();
	}

	/**
	 * Traverses binary tree in pre-order manner.
	 * 
	 * @param root
	 *            - the binary tree to be traversed.
	 */
	private void traversePreOrder(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getValue() + " ");
		preOrderCollection.add(root.getValue().toString());
		traversePreOrder(root.getLeftChild());
		traversePreOrder(root.getRightChild());
	}

	/**
	 * Traverses binary tree in pre-order manner.
	 * 
	 * @param root
	 *            - the binary tree to be traversed.
	 * @return the tree to sorted array
	 */
	public String[] preOrderToArray(BinaryTreeNode<T> root) {

		String[] array2 = new String[preOrderCollection.size()];

		int i = 0;
		for (String s : preOrderCollection) {
			array2[i] = s;
			i++;
		}
		return array2;
	}

	/**
	 * Traverses and prints the binary tree in pre-order manner.
	 */
	public void printPreOrder() {
		traversePreOrder(this.getRoot());
		System.out.println();
	}

	/**
	 * Traverses binary tree in post-order manner.
	 * 
	 * @param root
	 *            - the binary tree to be traversed.
	 */
	private void traversePostOrder(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}
		traversePostOrder(root.getLeftChild());
		traversePostOrder(root.getRightChild());
		System.out.print(root.getValue() + " ");
		postOrderCollection.add(root.getValue().toString());
	}

	/**
	 * Traverses binary tree in post-order manner.
	 * 
	 * @param root
	 *            - the binary tree to be traversed.
	 * @return the tree to sorted array
	 */
	public String[] postOrderToArray(BinaryTreeNode<T> root) {

		String[] array2 = new String[postOrderCollection.size()];

		int i = 0;
		for (String s : postOrderCollection) {
			array2[i] = s;
			i++;
		}
		return array2;
	}

	/**
	 * Traverses and prints the binary tree in post-order manner.
	 */
	public void printPostOrder() {
		traversePostOrder(this.getRoot());
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
