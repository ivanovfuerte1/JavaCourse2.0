package com.sirma.itt.javacourse.threads.synchronizedstack;

/**
 * The class {@link Adder} contains a method for adding an element to a list.
 */
public class Adder implements Runnable {
	private SynchronizedStack synchronizedStack;
	private Object item;

	/**
	 * Constructs an object with given list and element to add.
	 * 
	 * @param synchronizedStack
	 *            the list with elements
	 * @param item
	 *            the element to add
	 */
	public Adder(SynchronizedStack synchronizedStack, Object item) {
		this.synchronizedStack = synchronizedStack;
		this.item = item;
	}

	@Override
	public void run() {
		synchronizedStack.add(item);
	}

}
