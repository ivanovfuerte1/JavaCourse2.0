package com.sirma.itt.javacourse.threads.producerconsumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link Consumer} contains a method for running a thread for selling an item from the
 * repository.
 */
public class Consumer extends Thread {
	private Repository repository;
	private static final Logger LOGGER = LogManager.getLogger(Consumer.class);

	/**
	 * Constructs an object assigning a given repository to its variable repository.
	 * 
	 * @param repository
	 *            the repository where items are stored
	 */
	public Consumer(Repository repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		repository.sell();
		repository.setProductsInStorage(repository.getProductsInStorage() - 1);
		LOGGER.info("One item removed");
	}

}
