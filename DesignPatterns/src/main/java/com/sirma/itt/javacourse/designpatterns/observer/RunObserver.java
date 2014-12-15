package com.sirma.itt.javacourse.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link RunObserver} contains a method for testing the methods of the classes
 * {@link Article}, {@link AvailableArticles} and {@link SoldArticles} with sample values.
 */
public final class RunObserver {
	private static final Logger LOGGER = LogManager.getLogger(RunObserver.class);

	/**
	 * Default constructor.
	 */
	private RunObserver() {
	}

	/**
	 * Tests the methods of the classes {@link Article}, {@link AvailableArticles} and
	 * {@link SoldArticles} with sample values.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		Article firstArticle = new Article("Article 10001", 1);
		Article secondArticle = new Article("Article 10002", 2);
		List<Article> article = new ArrayList<Article>();
		article.add(firstArticle);
		article.add(secondArticle);
		Observer observer = new ConcreteObserver();
		AvailableArticles availableArticles = new AvailableArticles(observer);
		SoldArticles soldArticles = new SoldArticles();
		availableArticles.register(article.get(0), availableArticles, soldArticles);
		availableArticles.register(article.get(1), availableArticles, soldArticles);
		List<Article> currentList = availableArticles.getAvailableArticles();
		secondArticle.setQuantity(0);
		availableArticles.unregister(article.get(1), availableArticles, soldArticles);
		for (Article currentArticle : currentList) {
			LOGGER.info("Available Articles: " + currentArticle.getNameArticle() + " - Quantity: "
					+ currentArticle.getQuantity());
		}
		List<Article> currentSoldArticles = soldArticles.getSoldArticles();
		for (Article currentArticle : currentSoldArticles) {
			LOGGER.info("Sold Articles: " + currentArticle.getNameArticle() + " - Quantity: "
					+ currentArticle.getQuantity());
		}
		secondArticle.setQuantity(2);
		availableArticles.register(article.get(1), availableArticles, soldArticles);
		for (Article currentArticle : currentList) {
			LOGGER.info("Available Articles: " + currentArticle.getNameArticle() + " - Quantity: "
					+ currentArticle.getQuantity());
		}
		currentSoldArticles = soldArticles.getSoldArticles();
		for (Article currentArticle : currentSoldArticles) {
			LOGGER.info("Sold Articles: " + currentArticle.getNameArticle() + " - Quantity: "
					+ currentArticle.getQuantity());
		}

	}
}
