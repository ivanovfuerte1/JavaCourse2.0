package com.sirma.itt.javacourse.networking.downloadagent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class {@link DownloadAgentModel} contains methods for downloading a file from a given
 * location. It also works with web pages.
 */
public class DownloadAgentModel extends Thread {
	private DownloadAgentView downloadAgentView;
	private String fileName;
	private String urlString;
	private static final Logger LOGGER = LogManager.getLogger(DownloadAgentModel.class);

	/**
	 * Constructs an object of the {@link DownloadAgentModel} assigning its user interface, name of
	 * destination file and resource locator.
	 * 
	 * @param downloadAgentView
	 *            the user interface of the download agent
	 * @param fileName
	 *            the name of the file to download to
	 * @param urlString
	 *            the web address to download from
	 */
	public DownloadAgentModel(DownloadAgentView downloadAgentView, String fileName, String urlString) {
		this.downloadAgentView = downloadAgentView;
		this.fileName = fileName;
		this.urlString = urlString;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		FileOutputStream outFile = null;
		InputStream in = null;
		try {
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			long lengthURL = connection.getContentLengthLong();
			outFile = new FileOutputStream(fileName);
			in = connection.getInputStream();
			byte[] b = new byte[1];
			long bytesRead = 0;
			float progress = 1;
			downloadAgentView.disableButton();
			while ((bytesRead = in.read(b)) != -1) {
				outFile.write(b);
				outFile.flush();
				progress += (float) bytesRead * 100 / lengthURL;
				downloadAgentView.setProgress((int) progress);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStreams(outFile, in);
			downloadAgentView.setProgress(100);
			downloadAgentView.endDownload();
		}
	}

	/**
	 * Closes the streams used.
	 * 
	 * @param outFile
	 *            the file output stream
	 * @param in
	 *            the input stream
	 */
	private void closeStreams(FileOutputStream outFile, InputStream in) {
		try {
			in.close();
			outFile.close();
		} catch (IOException e) {
			LOGGER.error("An I/O operation is failed or interrupted", e);
		}
	}

}
