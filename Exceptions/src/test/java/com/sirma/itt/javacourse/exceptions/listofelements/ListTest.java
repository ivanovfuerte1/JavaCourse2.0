package com.sirma.itt.javacourse.exceptions.listofelements;

import org.junit.Test;

/**
 * @author Svetlosar Kovatchev
 */
public class ListTest {

	private int[] threeElementList = { 3, 5, 8 };
	private int[] twoElementList = { 2, 5 };

	/**
	 * @throws FullListException
	 *             whenever the list is full
	 */
	@Test(expected = FullListException.class)
	public void testAdd() throws FullListException {
		ListOfElements listOfElements = new ListOfElements();
		for (int i = 0; i < threeElementList.length; i++) {
			listOfElements.add(threeElementList[i]);
		}
	}

	/**
	 * @throws EmptyListException
	 *             whenever the list is empty
	 * @throws FullListException
	 *             whenever the list is full
	 */
	@Test(expected = EmptyListException.class)
	public void testRemove() throws EmptyListException, FullListException {
		ListOfElements listOfElements = new ListOfElements();
		for (int i = 0; i < twoElementList.length; i++) {
			listOfElements.add(twoElementList[i]);
		}
		for (int i = 0; i <= twoElementList.length; i++) {
			listOfElements.remove();
		}
	}
}
