package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class AvailableArticles {
	private List<Article> availableArticles = new ArrayList<>();

	private Observer observer;

	public AvailableArticles(Observer observer) {
		this.observer = observer;
	}

	public void register(Article article) {
		availableArticles.add(article);
		notifyObserver(article);
	}

	public void unregister(Article article) {
		if (availableArticles.contains(article)) {
			availableArticles.remove(article);
			notifyObserver(article);
		} else {
			// SOME LOGGER
		}
	}

	public void notifyObserver(Article article) {
		observer.update(article);
	}

	public List<Article> getAvailableArticles() {
		return availableArticles;
	}

	public void setAvailableArticles(List<Article> availableArticles) {
		this.availableArticles = availableArticles;
	}

}
