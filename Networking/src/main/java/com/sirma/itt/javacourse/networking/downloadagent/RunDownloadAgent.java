package com.sirma.itt.javacourse.networking.downloadagent;

/**
 * The class {@link RunDownloadAgent} contains methods for downloading a simple image from the
 * Internet.
 */
public class RunDownloadAgent {
	/**
	 * Downloads a simple image from the Internet.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		new DownloadAgentController("outFile3.jpg",
				"http://arenawallpapers.com/wp-content/uploads/2015/02/8c8LXdgcX.jpg");
	}

}
