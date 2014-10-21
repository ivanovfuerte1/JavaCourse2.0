package com.sirma.itt.javacourse.exceptions.listofelements;

import java.util.Date;

import org.junit.Test;

import com.sirma.itt.javacourse.objects.sumator.Sumator;

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

	/**
	 * @throws FullListException
	 *             whenever the list is full
	 */
	@Test(expected = FullListException.class)
	public void testAdd2() throws FullListException {
		ListOfElements listOfElements = new ListOfElements(5);
		listOfElements.add("a");
		listOfElements.add(6.5f);
		listOfElements.add(new Sumator());
		listOfElements.add(64184186417687681818671.6814871917898716817651);
		listOfElements.add(new Date());
		listOfElements.add(5.686868);
	}

	/**
	 * @throws EmptyListException
	 *             whenever the list is empty
	 * @throws FullListException
	 *             whenever the list is full
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeSizeList() throws EmptyListException, FullListException {
		new ListOfElements(-5);
	}
}
