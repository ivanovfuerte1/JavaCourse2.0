package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link AvailableArticles} contains a list of available articles with getter and setter
 * as well as methods for registering and unregistering articles to it.
 */
public class AvailableArticles {
	private List<Article> availableArticles = new ArrayList<>();
	private Observer observer;
	private static final Logger LOGGER = LogManager.getLogger(AvailableArticles.class);

	/**
	 * Constructs a new list of available articles with given observer.
	 * 
	 * @param observer
	 *            the observer assigned to keep track of registering and unregistering
	 */
	public AvailableArticles(Observer observer) {
		this.observer = observer;
	}

	/**
	 * Registers a new article to the list of available articles if and only if it is not already in
	 * the list.
	 * 
	 * @param article
	 *            the article to register
	 * @param availableArticles2
	 *            the list of available articles
	 * @param soldArticles
	 *            the list of sold articles
	 */
	public void register(Article article, AvailableArticles availableArticles2,
			SoldArticles soldArticles) {
		if (!availableArticles.contains(article)) {
			availableArticles.add(article);
			notifyObserver(article, availableArticles2, soldArticles);
		} else {
			LOGGER.error("The article is already in the list");
		}
	}

	/**
	 * Unregisters an article from the list of available articles if and only if it is already in
	 * the list.
	 * 
	 * @param article
	 *            the article to unregister
	 * @param availableArticles2
	 *            the list of available articles
	 * @param soldArticles
	 *            the list of sold articles
	 */
	public void unregister(Article article, AvailableArticles availableArticles2,
			SoldArticles soldArticles) {
		if (availableArticles.contains(article)) {
			availableArticles.remove(article);
			notifyObserver(article, availableArticles2, soldArticles);
		} else {
			LOGGER.error("The article is not in the list");
		}
	}

	/**
	 * Notifies the observer for changes in the list of available articles so that it can update the
	 * list of sold articles.
	 * 
	 * @param article
	 *            the article to update the list for
	 * @param availableArticles2
	 *            the list of available articles
	 * @param soldArticles
	 *            the list of sold articles
	 */
	public void notifyObserver(Article article, AvailableArticles availableArticles2,
			SoldArticles soldArticles) {
		observer.update(article, availableArticles2, soldArticles);
	}

	/**
	 * Returns the list of available articles in its actual state.
	 * 
	 * @return the list of available articles
	 */
	public List<Article> getAvailableArticles() {
		return availableArticles;
	}

	/**
	 * Sets a new values for the list of available articles.
	 * 
	 * @param availableArticles
	 *            the list of available articles
	 */
	public void setAvailableArticles(List<Article> availableArticles) {
		this.availableArticles = availableArticles;
	}

}
