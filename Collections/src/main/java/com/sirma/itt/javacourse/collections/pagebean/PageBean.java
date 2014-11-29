package com.sirma.itt.javacourse.collections.pagebean;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link PageBean} contains methods for separating a given list of elements into pages
 * and turning the pages. Moreover it has methods for checking whether the page is the first or the
 * last and for going straight to the first or the last page.
 * 
 * @author Svetlosar Kovatchev
 */
public class PageBean {
	private List<List<String>> paginator = new ArrayList<>();
	private static final int PAGE_SIZE = 3;
	private int counterOfPages = 0;
	private int currentPage = 1;
	private int lastPageElementsCounter = 0;
	private boolean startProgram = true;

	/**
	 * The method separatePages divides the list of elements from the input into pages.
	 * 
	 * @param elementsFromInput
	 *            a list of elements from the input
	 * @return a list of pages containing the elements form the input
	 */
	public List<List<String>> separatePages(List<String> elementsFromInput) {
		int currentElement = 0;
		int numberOfPages = elementsFromInput.size() / PAGE_SIZE;
		for (int i = 0; i < numberOfPages; i++) {
			List<String> currentPage = elementsFromInput.subList(currentElement, currentElement
					+ PAGE_SIZE);
			currentElement += PAGE_SIZE;
			paginator.add(currentPage);
			counterOfPages++;
		}
		lastPageElementsCounter = elementsFromInput.size() % PAGE_SIZE;
		if (lastPageElementsCounter != 0) {
			List<String> currentPage = elementsFromInput.subList(currentElement, currentElement
					+ lastPageElementsCounter);
			paginator.add(currentPage);
			counterOfPages++;
		}
		return paginator;
	}

	/**
	 * Goes straight to the first page and returns it.
	 * 
	 * @return the first page
	 */
	public List<String> firstPage() {
		// the startProgram flag is turned to false in order to avoid wrong result of consequent
		// call to the method next(when method firstPage is called first).
		startProgram = false;
		currentPage = 1;
		return paginator.get(currentPage - 1);
	}

	/**
	 * Goes straight to the last page and returns it.
	 * 
	 * @return the last page
	 */
	public List<String> lastPage() {
		// the startProgram flag is turned to false in order to avoid wrong result of consequent
		// call to the method next(when method firstPage is called first).
		startProgram = false;
		currentPage = counterOfPages;
		return paginator.get(currentPage - 1);
	}

	/**
	 * Goes to the next page and returns it.
	 * 
	 * @return the next page
	 * @throws LastPageReached
	 *             if the last page is reached
	 */
	public List<String> next() throws LastPageReached {
		if (startProgram) {
			startProgram = false;
		} else if (currentPage != counterOfPages) {
			currentPage++;
		} else if (lastPageElementsCounter == 0) {
			throw new LastPageReached("The last page is reached!", null);
			// currentPage++;
			// return paginator.get(currentPage);
		}
		return paginator.get(currentPage - 1);
	}

	/**
	 * Goes to the next page and returns it.
	 * 
	 * @return the previous page
	 * @throws FirstPageReached
	 *             if the first page is reached
	 */
	public List<String> previous() throws FirstPageReached {
		currentPage -= 1;
		if (currentPage == 0) {
			throw new FirstPageReached("The first page is reached!", null);
		}
		return paginator.get(currentPage - 1);
	}

	/**
	 * Checks whether the page is not last and returns a boolean result.
	 * 
	 * @return whether there is a consequent page
	 */
	public boolean hasNext() {
		if (currentPage == counterOfPages) {
			return false;
		}
		return true;
	}

	/**
	 * Checks whether the page is not first and returns a boolean result.
	 * 
	 * @return whether there is a previous page
	 */
	public boolean hasPrevious() {
		if (currentPage == 1) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the number of the current page.
	 * 
	 * @return the number of the current page
	 */
	public int getCurrentPageNumber() {
		return currentPage;
	}

}