package com.sirma.itt.javacourse.threads.synchronizedstack;

/**
 * The class {@link Remover} contains a method for removing an element from a list.
 */
public class Remover implements Runnable {
	private SynchronizedStack synchronizedStack;

	/**
	 * Constructs an object with a given list.
	 * 
	 * @param synchronizedStack
	 *            the list from the input
	 */
	public Remover(SynchronizedStack synchronizedStack) {
		this.synchronizedStack = synchronizedStack;
	}

	@Override
	public void run() {
		synchronizedStack.remove();
	}

}
