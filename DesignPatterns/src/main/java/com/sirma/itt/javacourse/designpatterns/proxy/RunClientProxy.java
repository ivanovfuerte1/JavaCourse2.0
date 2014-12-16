package com.sirma.itt.javacourse.designpatterns.proxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link RunClientProxy} contains methods for testing the method create instance of the
 * class {@link IntegerFactory}.
 */
public final class RunClientProxy {
	private static final Logger LOGGER = LogManager.getLogger(RunClientProxy.class);

	/**
	 * Default constructor.
	 */
	private RunClientProxy() {
	}

	/**
	 * Tests the method create instance of the class {@link IntegerFactory}.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		LOGGER.info(new IntegerFactory().createInstance().getInteger());
	}
}
