package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class AvailableArticles {
	private List<Article> availableArticles = new ArrayList<>();

	private Observer observer;

	public AvailableArticles(Observer observer) {
		this.observer = observer;
	}

	public void register(Article article, AvailableArticles availableArticles2,
			SoldArticles soldArticles) {
		availableArticles.add(article);
		notifyObserver(article, availableArticles2, soldArticles);
	}

	public void unregister(Article article, AvailableArticles availableArticles2,
			SoldArticles soldArticles) {
		if (availableArticles.contains(article)) {
			availableArticles.remove(article);
			notifyObserver(article, availableArticles2, soldArticles);
		} else {
			// SOME LOGGER
		}
	}

	public void notifyObserver(Article article, AvailableArticles availableArticles2,
			SoldArticles soldArticles) {
		observer.update(article, availableArticles2, soldArticles);
	}

	public List<Article> getAvailableArticles() {
		return availableArticles;
	}

	public void setAvailableArticles(List<Article> availableArticles) {
		this.availableArticles = availableArticles;
	}

}
