package com.sirma.itt.javacourse.inputoutput.directorybrowser;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link Run} contains a method for testing the method listTesting of the class
 * {@link DirectoryBrowser} with a sample directory and a file.
 * 
 * @author Svetlosar Kovatchev
 */
public final class Run {
	private static final Logger LOGGER = LogManager.getLogger(Run.class);
	private static final String SAMPLE_DIRECTORY = "asd";
	private static final String SAMPLE_FILE = "C:\\Users\\kovachev\\Desktop\\SirmaITTAdditionalMaterials\\Beginner's stuff\\Helping files task 3\\Hangman.jar";

	/**
	 * Default constructor.
	 */
	private Run() {
	}

	/**
	 * Invokes the method listContent of the class {@link DirectoryBrowser} and tests it with sample
	 * directory.
	 * 
	 * @param args
	 *            default arguments
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static void main(String[] args) throws IOException {
		try {
			String result = DirectoryBrowser.listContent(SAMPLE_DIRECTORY);
			System.out.println(result);
			// DirectoryBrowser.listContent(SAMPLE_FILE);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}
