package com.sirma.itt.javacourse.networking.downloadagent;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class {@link DownloadAgentController} contains methods for performing download.
 */
public class DownloadAgentController implements ActionListener {
	private DownloadAgentView downloadAgentView;
	private DownloadAgentModel downloadAgentModel;
	private String fileName;
	private String urlString;

	/**
	 * Constructs a new {@link DownloadAgentController} assigning data to its variables.
	 * 
	 * @param fileName
	 *            the name of the new file created
	 * @param urlString
	 *            the address to download the file from
	 */
	public DownloadAgentController(String fileName, String urlString) {
		this.downloadAgentView = new DownloadAgentView(this);
		this.fileName = fileName;
		this.urlString = urlString;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.downloadAgentModel = new DownloadAgentModel(downloadAgentView, fileName, urlString);
		downloadAgentModel.start();
		downloadAgentView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

	}

}
