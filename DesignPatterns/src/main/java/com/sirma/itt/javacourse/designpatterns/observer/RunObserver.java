package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class RunObserver {

	public static void main(String[] args) {
		Article firstArticle = new Article("Article 10001", 1);
		Article secondArticle = new Article("Article 10002", 2);
		List<Article> article = new ArrayList<Article>();
		article.add(firstArticle);
		article.add(secondArticle);
		Observer observer = new ConcreteObserver();
		AvailableArticles availableArticles = new AvailableArticles(observer);
		SoldArticles soldArticles = new SoldArticles(observer);
		availableArticles.register(article.get(0), availableArticles, soldArticles);
		availableArticles.register(article.get(1), availableArticles, soldArticles);
		List<Article> currentList = availableArticles.getAvailableArticles();
		// for (Article currentArticle : currentList) {
		// System.out.println(currentArticle.getNameArticle());
		// System.out.println(currentArticle.getQuantity());
		// }
		secondArticle.setQuantity(0);
		// for (Article currentArticle : currentList) {
		// System.out.println(currentArticle.getNameArticle());
		// System.out.println(currentArticle.getQuantity());
		// }
		availableArticles.unregister(article.get(1), availableArticles, soldArticles);
		for (Article currentArticle : currentList) {
			System.out.println(currentArticle.getNameArticle());
			System.out.println(currentArticle.getQuantity());
		}
		List<Article> currentSoldArticles = soldArticles.getSoldArticles();
		for (Article currentArticle : currentSoldArticles) {
			System.out.println(currentArticle.getNameArticle());
			System.out.println(currentArticle.getQuantity());
		}
	}
}
