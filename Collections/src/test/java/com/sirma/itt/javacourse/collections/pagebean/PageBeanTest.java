package com.sirma.itt.javacourse.collections.pagebean;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Svetlosar Kovatchev
 */
public class PageBeanTest {
	private List<String> elementsFromInput = new ArrayList<>();

	/**
	 * Tests the expected exception of the method previous of the class {@link PageBean} when the
	 * current page is the first.
	 * 
	 * @throws LastPageReached
	 *             if the last page is reached
	 * @throws FirstPageReached
	 *             if the first page is reached
	 */
	@Test(expected = FirstPageReached.class)
	public void test() throws LastPageReached, FirstPageReached {
		elementsFromInput.add("ace");
		elementsFromInput.add("2");
		elementsFromInput.add("3");
		elementsFromInput.add("4");
		elementsFromInput.add("5");
		elementsFromInput.add("6");
		elementsFromInput.add("7");
		elementsFromInput.add("8");
		elementsFromInput.add("9");
		elementsFromInput.add("10");
		elementsFromInput.add("jack");
		elementsFromInput.add("queen");
		elementsFromInput.add("king");
		PageBean pageBean = new PageBean();
		pageBean.separatePages(elementsFromInput);
		pageBean.firstPage();
		pageBean.lastPage();
		pageBean.previous();
		pageBean.previous();
		pageBean.next();
		pageBean.hasNext();
		pageBean.previous();
		pageBean.previous();
		pageBean.previous();
		pageBean.previous();
	}

	/**
	 * Tests whether the current page is the expected.
	 * 
	 * @throws LastPageReached
	 *             if the last page is reached
	 * @throws FirstPageReached
	 *             if the first page is reached
	 */
	@Test
	public void test2() throws LastPageReached, FirstPageReached {
		elementsFromInput.add("ace");
		elementsFromInput.add("2");
		elementsFromInput.add("3");
		elementsFromInput.add("4");
		elementsFromInput.add("5");
		elementsFromInput.add("6");
		elementsFromInput.add("7");
		elementsFromInput.add("8");
		elementsFromInput.add("9");
		elementsFromInput.add("10");
		elementsFromInput.add("jack");
		elementsFromInput.add("queen");
		elementsFromInput.add("king");
		PageBean pageBean = new PageBean();
		pageBean.separatePages(elementsFromInput);
		pageBean.firstPage();
		pageBean.lastPage();
		pageBean.previous();
		pageBean.previous();
		pageBean.next();
		pageBean.hasNext();
		pageBean.next();
		pageBean.next();
	}

	/**
	 * Tests the expected exception of the method next of the class {@link PageBean} when the
	 * current page is the last and the last page has the maximum permitted number of elements.
	 * 
	 * @throws LastPageReached
	 *             if the last page is reached
	 * @throws FirstPageReached
	 *             if the first page is reached
	 */
	@Test(expected = LastPageReached.class)
	public void test3() throws LastPageReached, FirstPageReached {
		elementsFromInput.add("ace");
		elementsFromInput.add("2");
		elementsFromInput.add("3");
		elementsFromInput.add("4");
		elementsFromInput.add("5");
		elementsFromInput.add("6");
		elementsFromInput.add("7");
		elementsFromInput.add("8");
		elementsFromInput.add("9");
		elementsFromInput.add("10");
		elementsFromInput.add("jack");
		elementsFromInput.add("queen");
		PageBean pageBean = new PageBean();
		pageBean.separatePages(elementsFromInput);
		pageBean.next();
		pageBean.firstPage();
		pageBean.lastPage();
		pageBean.previous();
		pageBean.previous();
		pageBean.next();
		pageBean.hasNext();
		pageBean.next();
		pageBean.next();
	}

	/**
	 * Tests the result of the method next of the class {@link PageBean} when the list of elements
	 * is empty.
	 * 
	 * @throws LastPageReached
	 *             if the last page is reached
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void test4() throws LastPageReached {
		PageBean pageBean = new PageBean();
		pageBean.separatePages(elementsFromInput);
		pageBean.next();
	}

	/**
	 * Tests the expected result of the method next of the class {@link PageBean} when the current
	 * page is the last and the last page does not have the maximum permitted number of elements.
	 * 
	 * @throws LastPageReached
	 *             if the last page is reached
	 * @throws FirstPageReached
	 *             if the first page is reached
	 */
	@Test
	public void test5() throws LastPageReached, FirstPageReached {
		elementsFromInput.add("ace");
		elementsFromInput.add("2");
		elementsFromInput.add("3");
		elementsFromInput.add("4");
		elementsFromInput.add("5");
		elementsFromInput.add("6");
		elementsFromInput.add("7");
		elementsFromInput.add("8");
		elementsFromInput.add("9");
		elementsFromInput.add("10");
		elementsFromInput.add("jack");
		elementsFromInput.add("queen");
		elementsFromInput.add("king");
		PageBean pageBean = new PageBean();
		pageBean.separatePages(elementsFromInput);
		pageBean.firstPage();
		pageBean.next();
		pageBean.next();
		pageBean.next();
		pageBean.next();
		pageBean.previous();
		pageBean.previous();
		pageBean.previous();
		pageBean.next();
		pageBean.next();
		pageBean.next();
		pageBean.next();
	}
}
