package com.sirma.itt.javacourse.designpatterns.observer;

public class ConcreteObserver implements Observer {
	// private AvailableArticles availableArticles;
	// private SoldArticles soldArticles;

	@Override
	public void update(Article article, AvailableArticles availableArticles2,
			SoldArticles soldArticles) {
		if (article.getQuantity() <= 0) {
			soldArticles.register(article);
			// availableArticles2.unregister(article);
		} else {
			// availableArticles.register(article);
			soldArticles.unregister(article);
		}
	}

	// public SoldArticles getSoldArticles() {
	// return soldArticles;
	// }
	//
	// public AvailableArticles getAvailableArticles() {
	// return availableArticles;
	// }

}
