package com.sirma.itt.javacourse.threads.stopcounterthread;

import java.io.IOException;
import java.util.Scanner;

/**
 * The class {@link StopCounterThread} contains a method for running a thread and stopping when an
 * input from the console is present.
 */
public final class StopCounterThread {
	/**
	 * Default constructor.
	 */
	private StopCounterThread() {
	}

	/**
	 * The main method creates and runs a new thread. It stops the thread as soon as an input from
	 * the console is present.
	 * 
	 * @param args
	 *            default arguments
	 * @throws InterruptedException
	 *             when a thread is waiting, sleeping, or otherwise occupied, and the thread is
	 *             interrupted, either before or during the activity
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		Thread t = new Thread(new CounterThread());
		t.start();
		try (Scanner SCANNER = new Scanner(System.in)) {
			String input = null;
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
