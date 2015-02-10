package com.sirma.itt.javacourse.threads.synchronizedstack;

/**
 * The class {@link RunSyncStack} contains a method for testing the possibility of running several
 * threads for adding and removing elements of a list without conflict.
 */
public final class RunSyncStack {

	/**
	 * Runs several threads simultaneously and proves there is no conflict among them.
	 * 
	 * @param args
	 *            default arguments
	 * @throws InterruptedException
	 *             when a thread is waiting, sleeping, or otherwise occupied, and the thread is
	 *             interrupted, either before or during the activity
	 */
	public static void main(String[] args) throws InterruptedException {
		Object[] sampleArray = new Object[2];
		SynchronizedStack synchronizedStack = new SynchronizedStack(sampleArray, 0);
		(new Thread(new Adder(synchronizedStack, 11))).start();
		(new Thread(new Adder(synchronizedStack, 12))).start();
		Thread.sleep(1000);
		synchronizedStack.print();
		(new Thread(new Remover(synchronizedStack))).start();
		(new Thread(new Adder(synchronizedStack, 13))).start();
		Thread.sleep(1000);
		synchronizedStack.print();
		(new Thread(new Adder(synchronizedStack, 14))).start();
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(1000);
		synchronizedStack.print();
		(new Thread(new Remover(synchronizedStack))).start();
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(1000);
		synchronizedStack.print();
		(new Thread(new Remover(synchronizedStack))).start();
		(new Thread(new Adder(synchronizedStack, 15))).start();
		Thread.sleep(1000);
		synchronizedStack.print();
	}
}
