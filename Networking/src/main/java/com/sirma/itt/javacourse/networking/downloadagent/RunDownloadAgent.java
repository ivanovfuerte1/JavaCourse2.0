package com.sirma.itt.javacourse.networking.downloadagent;

/**
 * The class {@link RunDownloadAgent} contains a method for downloading a sample image from the
 * Internet by the methods of the class {@link DownloadAgent}.
 */
public final class RunDownloadAgent {
	/**
	 * Default constructor.
	 */
	private RunDownloadAgent() {
	}

	/**
	 * Downloads a sample file from the Internet.
	 * 
	 * @param args
	 *            default arguments
	 */
	public static void main(String[] args) {
		DownloadAgent downloadAgent = new DownloadAgent();
		downloadAgent
				.downloadFile(
						"http://www.wallpaperbod.com/wallpapers/2013/05/Free-Beautiful-Landscape-Desktop-Wallpaper-06-2010-98-1800x2880.jpg",
						"outFile.jpg");
	}

}
