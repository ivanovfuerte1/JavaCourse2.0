package com.sirma.itt.javacourse.networking.downloadagent;

/**
 * The class {@link RunDownloadWebPage} contains a method for downloading a web page from the
 * Internet.
 */
public class RunDownloadWebPage {
	/**
	 * Downloads a web page from the Internet.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		new DownloadAgentController("outFile1.html", "http://www.data.bg");
	}
}
