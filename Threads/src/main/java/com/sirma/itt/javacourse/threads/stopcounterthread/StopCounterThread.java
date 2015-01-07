package com.sirma.itt.javacourse.threads.stopcounterthread;

import java.util.Scanner;

/**
 * The class {@link StopCounterThread} contains a method for running a thread and stopping when an
 * input from the console is present.
 */
public final class StopCounterThread {

	/**
	 * Creates and runs a new thread. It stops the thread as soon as an input from the console is
	 * present.
	 */
	public void waitForInput() {
		Thread t = new Thread(new CounterThread());
		t.start();
		String input = null;
		try (Scanner SCANNER = new Scanner(System.in)) {
			while (true) {
				input = SCANNER.nextLine();
				if (input != null) {
					t.interrupt();
					break;
				}
			}
		}
	}
}
