package com.sirma.itt.javacourse.objects.binarysearchtree;

/**
 * The class BinaryTreeNode contains a constructor for the current binary tree node.
 * 
 * @param <T>
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {
	private T value;
	private BinaryTreeNode<T> leftChild;
	private BinaryTreeNode<T> rightChild;

	/**
	 * Constructs the tree node.
	 * 
	 * @param value
	 *            the new value
	 */
	public BinaryTreeNode(T value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	@Override
	public int hashCode() {
		return this.value.hashCode();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		BinaryTreeNode<T> other = (BinaryTreeNode<T>) obj;
		return this.compareTo(other) == 0;
	}

	/**
	 * Returns the result of the comparison.
	 * 
	 * @param other
	 *            the value to be compared with
	 * @return the result of comparison
	 */
	public int compareTo(BinaryTreeNode<T> other) {
		return this.value.compareTo(other.value);
	}

	/**
	 * Gets the value of the node.
	 * 
	 * @return the value of the node
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Returns the left child.
	 * 
	 * @return the left child or null if it does not exists
	 */
	public BinaryTreeNode<T> getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Sets the left child.
	 * 
	 * @param value
	 *            the value to be set as a left child
	 */
	public void setLeftChild(BinaryTreeNode<T> value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.leftChild = value;
	}

	/**
	 * Returns the right child.
	 * 
	 * @return the right child or null if it does not exists
	 */
	public BinaryTreeNode<T> getRightChild() {
		return this.rightChild;
	}

	/**
	 * Sets the right child.
	 * 
	 * @param value
	 *            the value to be set as a right child
	 */
	public void setRightChild(BinaryTreeNode<T> value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.rightChild = value;
	}
}