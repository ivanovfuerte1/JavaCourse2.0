package com.sirma.itt.javacourse.inputoutput.directorybrowser;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The class {@link DirectoryBrowser} contains method for displaying the contents of a directory of
 * the file system.
 * 
 * @author Svetlosar Kovatchev
 */
public final class DirectoryBrowser {
	/**
	 * Default constructor.
	 */
	private DirectoryBrowser() {
	}

	/**
	 * Traverses the contents of a given directory. In case a path to file is set instead of path to
	 * variable a message will be displayed.
	 * 
	 * XXX: What about files in sub directories?
	 * 
	 * @param path
	 *            - the path to the directory which should be traversed.
	 * @return the contents of the given directory as a string
	 * @throws IOException
	 *             if an I/O operation is failed or interrupted
	 */
	public static String listContent(String path) throws IOException {
		File fileCheck = new File(path);
		// XXX: add condition for invalid input.
		if (fileCheck.isFile()) {
			throw new IllegalArgumentException("The parameter is not a directory!");
		}
		StringBuilder sb = new StringBuilder();
		Path dir = Paths.get(path);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file : stream) {
				sb.append(file.getFileName());
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}
}
