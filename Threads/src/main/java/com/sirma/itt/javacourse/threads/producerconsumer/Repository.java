package com.sirma.itt.javacourse.threads.producerconsumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link Repository} contains methods for selling and buying articles from repository.
 */
public class Repository {
	private static int productsInStorage = 0;
	private static final Logger LOGGER = LogManager.getLogger(Repository.class);

	/**
	 * Returns the current number of articles in the repository.
	 * 
	 * @return the current number of articles
	 */
	public synchronized int getProductsInStorage() {
		return productsInStorage;
	}

	/**
	 * Sets a new number of articles in the Repository.
	 * 
	 * @param productsInStorage
	 *            the new number of articles
	 */
	public synchronized void setProductsInStorage(int productsInStorage) {
		Repository.productsInStorage = productsInStorage;
	}

	/**
	 * Sells articles from the repository. If there are no articles to sell, waits until there is
	 * some supply.
	 */
	public synchronized void sell() {
		notify();
		while (productsInStorage == 0) {
			try {
				LOGGER.info("Waiting for production");
				wait();
			} catch (InterruptedException e) {
				LOGGER.error("The thread was interrupted while waiting.", e);
			}
			productsInStorage++;
		}
	}

	/**
	 * Supplies articles to the repository. If the repository is full it waits until there is some
	 * sell.
	 */
	public synchronized void supply() {
		notify();
		while (productsInStorage == 3) {
			try {
				wait();
				LOGGER.info("Waiting for place in repositoty");
			} catch (InterruptedException e) {
				LOGGER.error("The thread was interrupted while waiting.", e);
			}
			productsInStorage--;
		}
	}
}
