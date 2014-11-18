package com.sirma.itt.javacourse.collections.pagebean;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link RunPageBean} contains a method for testing the methods next and previous of the
 * class {@link PageBean}.
 * 
 * @author Svetlosar Kovatchev
 */
public final class RunPageBean {
	private static List<String> elementsFromInput = new ArrayList<>();

	/**
	 * Default constructor.
	 */
	private RunPageBean() {
	}

	/**
	 * Tests the methods next and previous of the class {@link PageBean}.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
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
		
//		System.out.println(pageBean.next());
//		System.out.println(pageBean.next());
//		System.out.println(pageBean.next());
//		System.out.println(pageBean.next());
//		System.out.println(pageBean.next());
//		System.out.println(pageBean.next());
//		System.out.println(pageBean.next());
		
		// pageBean.next();
		System.out.println(pageBean.previous());
		System.out.println(pageBean.previous());
	}

}
