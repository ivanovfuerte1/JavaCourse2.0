package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class SoldArticles {

	private List<Article> soldArticles = new ArrayList<>();

	// private Observer observer;

	public SoldArticles(Observer observer) {
		// this.observer = observer;
	}

	public void register(Article article) {
		if (!soldArticles.contains(article)) {
			soldArticles.add(article);
			// notifyObserver(article);
		} else {
			// SOME LOGGER
		}
	}

	public void unregister(Article article) {
		if (soldArticles.contains(article)) {
			soldArticles.remove(article);
		} else {
			// SOME LOGGER
		}

	}

	// IT SHOULD BE LIKE AVAILABLE ARTICLES.NOTIFY
	// private void notifyObserver(Article article) {
	// observer.update(article, null, null);
	//
	// }

	public List<Article> getSoldArticles() {
		return soldArticles;
	}

	public void setSoldArticles(List<Article> soldArticles) {
		this.soldArticles = soldArticles;
	}

}
