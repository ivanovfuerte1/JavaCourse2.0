package com.sirma.itt.javacourse.threads.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link RunProducerConsumer} tests waiting for sells in a sample repository.
 */
public final class RunProducerConsumer {
	/**
	 * Default constructor.
	 */
	private RunProducerConsumer() {
	}

	/**
	 * Runs several consumers while the repository is empty. Then starts producing so that consumers
	 * can be satisfied.
	 * 
	 * @param args
	 *            default arguments
	 * @throws InterruptedException
	 *             when a thread is waiting, sleeping, or otherwise occupied, and the thread is
	 *             interrupted, either before or during the activity
	 */
	public static void main(String[] args) throws InterruptedException {
		Repository repository = new Repository();
		// Object firstItem = "abc";
		// Object secondItem = "mno";
		// Object thirdItem = "xyz";
		List<Object> objects = new ArrayList<Object>();
		for (int i = 0; i < 100; i++) {
			objects.add(Math.random());
		}
		
		(new Consumer(repository)).start();
		Thread.sleep(1500);
		
		for (int i = 0; i < 100; i++) {
			(new Producer(repository, objects.get(i))).start();
		}
		
		
		// (new Consumer(repository)).start();
		// (new Consumer(repository)).start();
		
		
		// (new Producer(repository, secondItem)).start();
		// (new Producer(repository, thirdItem)).start();
	}
}
