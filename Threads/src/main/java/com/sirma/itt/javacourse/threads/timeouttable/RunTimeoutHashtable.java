package com.sirma.itt.javacourse.threads.timeouttable;

/**
 * The class {@link RunTimeoutHashtable} contains a method for testing the methods of the class
 * {@link Adder}.
 */
public final class RunTimeoutHashtable {
	/**
	 * Default constructor.
	 */
	private RunTimeoutHashtable() {
	}

	/**
	 * Tests the methods of the class Adder by getting a previously added element and this way
	 * refreshing it and delaying its removal.
	 * 
	 * @param args
	 *            default arguments
	 * @throws InterruptedException
	 *             when a thread is waiting, sleeping, or otherwise occupied, and the thread is
	 *             interrupted, either before or during the activity
	 */
	public static void main(String[] args) throws InterruptedException {
		TimeoutHashtable timeoutHashtable = new TimeoutHashtable();
		timeoutHashtable.put("a", 11);
		Thread.sleep(500);
		timeoutHashtable.put("b", 22);
		Thread.sleep(500);
		timeoutHashtable.getFirstAdder().get("a");
	}
}
