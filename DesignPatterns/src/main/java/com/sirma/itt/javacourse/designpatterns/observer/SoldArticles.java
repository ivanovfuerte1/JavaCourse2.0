package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link SoldArticles} contains a list of sold articles with getter and setter as well as
 * methods for registering and unregistering articles to it.
 */
public class SoldArticles {

	private List<Article> soldArticles = new ArrayList<>();
	private static final Logger LOGGER = LogManager.getLogger(SoldArticles.class);

	/**
	 * Registers a new article to the list of sold articles if and only if it is not already in the
	 * list.
	 * 
	 * @param article
	 *            the article to register
	 */
	public void register(Article article) {
		if (!soldArticles.contains(article)) {
			soldArticles.add(article);
		} else {
			LOGGER.error("The article is already in the list");
		}
	}

	/**
	 * Unregisters an article from the list of sold articles if and only if it is already in the
	 * list.
	 * 
	 * @param article
	 *            the article to unregister
	 */
	public void unregister(Article article) {
		if (soldArticles.contains(article)) {
			soldArticles.remove(article);
		} else {
			LOGGER.error("The article is not in the sold list - nothing to unregister.");
		}

	}

	/**
	 * Returns the list of sold articles in its actual state.
	 * 
	 * @return the list of sold articles
	 */
	public List<Article> getSoldArticles() {
		return soldArticles;
	}

	/**
	 * Sets a new values for the list of sold articles.
	 * 
	 * @param soldArticles
	 *            the list of sold articles
	 */
	public void setSoldArticles(List<Article> soldArticles) {
		this.soldArticles = soldArticles;
	}

}
