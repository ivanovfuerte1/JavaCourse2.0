package com.sirma.itt.javacourse.threads.producerconsumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link Producer} contains a method for running a thread for buying an item from the
 * repository.
 */
public class Producer extends Thread {
	private Repository repository;
	private Object item;
	private static final Logger LOGGER = LogManager.getLogger(Producer.class);

	/**
	 * Creates an object assigning a given repository to its variable repository and an item to
	 * store in the repository.
	 * 
	 * @param repository
	 *            the place where items are being stored
	 * @param item
	 *            the item to store in the repository
	 */
	public Producer(Repository repository, Object item) {
		this.repository = repository;
		this.item = item;
	}

	@Override
	public void run() {
		repository.supply();
		repository.setProductsInStorage(repository.getProductsInStorage() + 1);
		LOGGER.info(item + " Supplied");
	}

}
