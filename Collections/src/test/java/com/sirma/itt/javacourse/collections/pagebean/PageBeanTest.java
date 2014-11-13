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
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test() {
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
	 */
	@Test
	public void test2() {
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
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void test3() {
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
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void test4() {
		PageBean pageBean = new PageBean();
		pageBean.separatePages(elementsFromInput);
		pageBean.next();
	}

	/**
	 * Tests the expected result of the method next of the class {@link PageBean} when the current
	 * page is the last and the last page does not have the maximum permitted number of elements.
	 */
	@Test
	public void test5() {
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
