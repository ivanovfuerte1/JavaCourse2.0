package com.sirma.itt.javacourse.objects.heterogeneoustree;

/**
 * The class HeterogeneousTreeNode contains a constructor for the current heterogeneous tree node.
 * 
 * @author Svetlosar Kovatchev
 * @version 1.0
 */
public class HeterogeneousTreeNode
/* XXX: do not leave commented code! <T extends Comparable<T>> implement Comparable<HeterogeneousTreeNode<T>> */
{
	// Contains the value of the node
	private Object value;
	// XXX: why keep parent?
	// Contains the parent of the node
	private HeterogeneousTreeNode parent;
	// Contains the left child of the node
	private HeterogeneousTreeNode leftChild;
	// Contains the right child of the node
	private HeterogeneousTreeNode rightChild;

	/**
	 * Constructs the tree node.
	 * 
	 * @param value
	 *            the new value
	 */
	public HeterogeneousTreeNode(Object value) {
		this.value = value;
		this.parent = null;
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

	@Override
	public boolean equals(Object obj) {
		HeterogeneousTreeNode other = (HeterogeneousTreeNode) obj;
		System.out.println(this.parent.toString());
		return this.compareTo(other) == 0;
	}

	/**
	 * Returns the result of the comparison.
	 * 
	 * @param other
	 *            the value to be compared
	 * @return the result of the comparison
	 */
	public int compareTo(HeterogeneousTreeNode other) {
		return this.value.toString().compareTo(other.value.toString());
	}

	/**
	 * @return the value of the node.
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * Gets the value of the node's parent.
	 * 
	 * @return the value of the node's parent.
	 */
	public HeterogeneousTreeNode getParent() {
		return this.parent;
	}

	/**
	 * Sets the parent.
	 * 
	 * @param value
	 *            the new parent to be set
	 */
	public void setParent(HeterogeneousTreeNode value) {
		this.parent = value;
	}

	/**
	 * Returns the left child.
	 * 
	 * @return the left child or null if it does not exists.
	 */
	public HeterogeneousTreeNode getLeftChild() {
		return this.leftChild;
	}

	/**
	 * Sets the left child.
	 * 
	 * @param value
	 *            the new left child to be set
	 */
	public void setLeftChild(HeterogeneousTreeNode value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.leftChild = value;
	}

	/**
	 * Returns the right child.
	 * 
	 * @return the right child or null if it does not exists.
	 */
	public HeterogeneousTreeNode getRightChild() {
		return this.rightChild;
	}

	/**
	 * Sets the right child.
	 * 
	 * @param value
	 *            the new right child to be set
	 */
	public void setRightChild(HeterogeneousTreeNode value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.rightChild = value;
	}

}
