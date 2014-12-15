package com.sirma.itt.javacourse.designpatterns.observer;

/**
 * The class {@link Article} contains getters and setters for its variables - name and quantity.
 */
public class Article {
	private String nameArticle;
	private int quantity;

	/**
	 * Constructs an object of the class {@link Article} assigning values to its variables.
	 * 
	 * @param nameArticle
	 *            the name of the article
	 * @param quantity
	 *            the available quantity of this article
	 */
	public Article(String nameArticle, int quantity) {
		this.nameArticle = nameArticle;
		this.quantity = quantity;
	}

	/**
	 * Gets the name of the article.
	 * 
	 * @return the name of the article
	 */
	public String getNameArticle() {
		return nameArticle;
	}

	/**
	 * Set the name of the article.
	 * 
	 * @param nameArticle
	 *            the new name of the article
	 */
	public void setNameArticle(String nameArticle) {
		this.nameArticle = nameArticle;
	}

	/**
	 * Gets the available quantity of this article.
	 * 
	 * @return the available quantity of this article
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets a new available quantity of this article.
	 * 
	 * @param quantity
	 *            the new quantity of the article
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
