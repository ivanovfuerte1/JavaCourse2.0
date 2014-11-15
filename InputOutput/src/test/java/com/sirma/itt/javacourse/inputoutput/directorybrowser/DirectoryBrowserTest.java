package com.sirma.itt.javacourse.inputoutput.directorybrowser;

import java.io.IOException;

import org.junit.Test;

/**
 * The class {@link DirectoryBrowserTest} contains tests for the method listContent of the class
 * {@link DirectoryBrowser}.
 * 
 * @author Svetlosar Kovatchev
 */
public class DirectoryBrowserTest {
	private static final String SAMPLE_FILE = "C:\\Users\\kovachev\\Desktop\\SirmaITTAdditionalMaterials\\Beginner's stuff\\Helping files task 3\\Hangman.jar";
	private static final String BACKSLASH = "\"";

	/**
	 * Tests the method listContent with a file name as an input.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFileName() throws IOException {
		DirectoryBrowser.listContent(SAMPLE_FILE);
		throw new IllegalArgumentException();
	}

	/**
	 * Tests the method listContent with an invalid input.
	 * 
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInput() throws IOException {
		DirectoryBrowser.listContent(BACKSLASH);
		throw new IllegalArgumentException();
	}

}
