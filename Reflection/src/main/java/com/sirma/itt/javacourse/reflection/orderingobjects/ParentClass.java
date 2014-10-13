package com.sirma.itt.javacourse.reflection.orderingobjects;

/**
 * The class {@link ParentClass} contains a method for describing the way two classes are being
 * compared.
 * 
 * @author Svetlosar Kovatchev
 */
public class ParentClass implements Comparable<ParentClass> {
	/**
	 * Compares two classes according to the value assigned in their annotation. Returns 1 in case
	 * the current class has a bigger value than the one being checked, 0 in case both values are
	 * equal, and -1 otherwise.
	 * 
	 * @param other
	 *            the class to compare
	 * @return the result of the comparison
	 */
	public int compareTo(ParentClass other) {
		if (this.getClass().getAnnotation(OrderAnnotation.class).value() > other.getClass()
				.getAnnotation(OrderAnnotation.class).value()) {
			return 1;
		} else
			return this.getClass().getAnnotation(OrderAnnotation.class).value() == other.getClass()
					.getAnnotation(OrderAnnotation.class).value() ? 0 : -1;
	}

}
