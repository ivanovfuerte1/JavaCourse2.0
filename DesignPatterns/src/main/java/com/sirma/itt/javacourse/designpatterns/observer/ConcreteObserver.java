package com.sirma.itt.javacourse.designpatterns.observer;

/**
 * The class {@link ConcreteObserver} contains a methods for updating the list of sold articles
 * according to the current state of the list of available articles.
 */
public class ConcreteObserver implements Observer {

	@Override
	public void update(Article article, AvailableArticles availableArticles2,
			SoldArticles soldArticles) {
		if (article.getQuantity() <= 0) {
			soldArticles.register(article);
		} else {
			soldArticles.unregister(article);
		}
	}

}
