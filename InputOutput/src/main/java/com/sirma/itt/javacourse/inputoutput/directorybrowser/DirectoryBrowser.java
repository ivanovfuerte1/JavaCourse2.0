package com.sirma.itt.javacourse.inputoutput.directorybrowser;

import java.io.File;
import java.io.IOException;

/**
 * The class {@link DirectoryBrowser} contains method for displaying the contents of a directory of
 * the file system.
 * 
 * @author Svetlosar Kovatchev
 */
public final class DirectoryBrowser {
	private static StringBuilder result = new StringBuilder();

	/**
	 * Default constructor.
	 */
	private DirectoryBrowser() {
	}

	/**
	 * Lists the contents of a given directory and its subdirectories. In case a path to file is set
	 * instead of path to variable a message will be displayed.
	 * 
	 * @param path
	 *            - the path to the directory to be traversed.
	 * @return the contents of the given directory as a string
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static String listContent(String path) throws IOException {
		File fileCheck = new File(path);
		if (!fileCheck.isFile() && !fileCheck.isDirectory()) {
			throw new IllegalArgumentException("The input contains invalid characters!");
		}
		if (fileCheck.isFile()) {
			throw new IllegalArgumentException("The parameter is not a directory!");
		}
		StringBuilder sb = traverseDir(new File(path));
		return sb.toString();
	}

	/**
	 * Traverses the given directory recursively.
	 * 
	 * @param dir
	 *            - the directory to be traversed.
	 * @return the contents of the given directory as a StringBuilder
	 */
	private static StringBuilder traverseDir(File dir) {
		result.append(dir.getName());
		result.append(System.lineSeparator());
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (String child : children) {
				traverseDir(new File(dir, child));
			}
		}
		return result;
	}

}
