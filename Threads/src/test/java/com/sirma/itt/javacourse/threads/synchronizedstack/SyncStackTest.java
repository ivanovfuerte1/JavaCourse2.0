package com.sirma.itt.javacourse.threads.synchronizedstack;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * The class {@link SyncStackTest} contains tests for the methods of the class
 * {@link SynchronizedStack} using several threads simultaneously.
 */
public class SyncStackTest {

	/**
	 * Tests the resulting array after adding and removing the same number of elements
	 * simultaneously.
	 * 
	 * @throws InterruptedException
	 *             when a thread is waiting, sleeping, or otherwise occupied, and the thread is
	 *             interrupted, either before or during the activity
	 */
	@Test
	public void testAllElementsRemoved() throws InterruptedException {
		Object[] sampleArray = new Object[2];
		SynchronizedStack synchronizedStack = new SynchronizedStack(sampleArray, 0);
		(new Thread(new Adder(synchronizedStack, 11))).start();
		Thread.sleep(100);
		(new Thread(new Adder(synchronizedStack, 12))).start();
		Thread.sleep(100);
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(100);
		(new Thread(new Adder(synchronizedStack, 13))).start();
		Thread.sleep(100);
		(new Thread(new Adder(synchronizedStack, 14))).start();
		Thread.sleep(100);
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(100);
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(100);
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(100);
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(100);
		(new Thread(new Adder(synchronizedStack, 15))).start();
		Thread.sleep(100);
		assertNull(synchronizedStack.getArray()[0]);
		assertNull(synchronizedStack.getArray()[1]);
	}

	/**
	 * Tests the resulting array after adding and removing elements simultaneously until one the
	 * last element is left.
	 * 
	 * @throws InterruptedException
	 *             when a thread is waiting, sleeping, or otherwise occupied, and the thread is
	 *             interrupted, either before or during the activity
	 */
	@Test
	public void testOneElementLeft() throws InterruptedException {
		Object[] sampleArray = new Object[2];
		SynchronizedStack synchronizedStack = new SynchronizedStack(sampleArray, 0);
		(new Thread(new Adder(synchronizedStack, 11))).start();
		Thread.sleep(100);
		(new Thread(new Adder(synchronizedStack, 12))).start();
		Thread.sleep(100);
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(100);
		(new Thread(new Adder(synchronizedStack, 13))).start();
		Thread.sleep(100);
		(new Thread(new Adder(synchronizedStack, 14))).start();
		Thread.sleep(100);
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(100);
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(100);
		(new Thread(new Remover(synchronizedStack))).start();
		Thread.sleep(100);
		(new Thread(new Adder(synchronizedStack, 15))).start();
		Thread.sleep(100);
		Object[] expected = new Object[] { 15, null };
		Object[] actuals = synchronizedStack.getArray();
		assertArrayEquals(expected, actuals);
	}

}
