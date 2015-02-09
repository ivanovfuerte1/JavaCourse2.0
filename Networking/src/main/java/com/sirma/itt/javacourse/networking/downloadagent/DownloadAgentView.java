package com.sirma.itt.javacourse.networking.downloadagent;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The class {@link DownloadAgentView} contains methods for setting a graphical interface of the
 * download agent.
 */
public class DownloadAgentView extends JFrame {
	private static final long serialVersionUID = 957596408632983696L;
	private JProgressBar progressBar;
	private JButton startButton;
	private JTextArea taskOutput;

	/**
	 * Constructs an user interface for the download agent.
	 * 
	 * @param downloadAgentController
	 *            the controller of the download
	 */
	public DownloadAgentView(DownloadAgentController downloadAgentController) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);

		startButton = new JButton("Start");
		startButton.setActionCommand("start");
		startButton.addActionListener(downloadAgentController);

		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);

		taskOutput = new JTextArea(5, 20);
		taskOutput.setMargin(new Insets(5, 5, 5, 5));
		taskOutput.setEditable(false);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel.add(startButton);
		panel.add(progressBar);
		panel.add(new JScrollPane(taskOutput));

		add(panel);
		setVisible(true);
	}

	/**
	 * Synchronizes the image of the progress bar with the part of the file already downloaded.
	 * 
	 * @param value
	 *            the part of the file already downloaded
	 */
	public void setProgress(int value) {
		progressBar.setValue(value);
	}

	/**
	 * Disables the button for download.
	 */
	public void disableButton() {
		startButton.setEnabled(false);
	}

	/**
	 * Sets the default cursor. Used when the download is finished.
	 */
	@SuppressWarnings("deprecation")
	public void endDownload() {
		setCursor(Cursor.DEFAULT_CURSOR);
	}
}
