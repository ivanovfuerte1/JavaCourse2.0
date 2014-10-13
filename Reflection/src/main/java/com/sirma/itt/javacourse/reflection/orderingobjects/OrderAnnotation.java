package com.sirma.itt.javacourse.reflection.orderingobjects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation {@link OrderAnnotation} contains a method for extracting the value which is the
 * key for ordering classes.
 * 
 * @author Svetlosar Kovatchev
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OrderAnnotation {
	/**
	 * Extracts a value which is the key for ordering classes.
	 */
	int value();
}
