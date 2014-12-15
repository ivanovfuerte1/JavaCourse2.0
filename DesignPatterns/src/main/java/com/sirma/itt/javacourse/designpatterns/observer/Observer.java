package com.sirma.itt.javacourse.designpatterns.observer;

/**
 * The interface {@link Observer} contains a method for updating the lists of the available articles
 * and sold articles according to the implementing concrete observer.
 */
public interface Observer {
	/**
	 * Updates the lists of the available articles and sold articles according to the implementing
	 * concrete observer.
	 * 
	 * @param article
	 *            the article contained in the lists
	 * @param availableArticles2
	 *            the list of available articles
	 * @param soldArticles
	 *            the list of sold articles
	 */
	void update(Article article, AvailableArticles availableArticles2, SoldArticles soldArticles);
}
