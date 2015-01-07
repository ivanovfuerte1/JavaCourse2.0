package com.sirma.itt.javacourse.networking.downloadagent;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

/**
 * The class {@link DownloadAgent} contains methods for downloading file from the Internet.
 */
public class DownloadAgent extends JPanel implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 6365642499369801016L;
	private JProgressBar progressBar;
	private JButton startButton;
	private JTextArea taskOutput;
	private Task task;
	private String urlString;
	private String fileName;

	/**
	 * Constructs an object of {@link DownloadAgent} creating user interface for it.
	 */
	public DownloadAgent() {
		super(new BorderLayout());

		startButton = new JButton("Start");
		startButton.setActionCommand("start");
		startButton.addActionListener(this);

		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);

		taskOutput = new JTextArea(5, 20);
		taskOutput.setMargin(new Insets(5, 5, 5, 5));
		taskOutput.setEditable(false);

		JPanel panel = new JPanel();
		panel.add(startButton);
		panel.add(progressBar);

		add(panel, BorderLayout.PAGE_START);
		add(new JScrollPane(taskOutput), BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	}

	/**
	 * Invoked when the user presses the start button.
	 * 
	 * @param evt
	 *            the event that calls this method
	 */
	public void actionPerformed(ActionEvent evt) {
		startButton.setEnabled(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		task = new Task();
		task.addPropertyChangeListener(this);
		task.execute();
	}

	/**
	 * Invoked when task's progress property changes.
	 * 
	 * @param evt
	 *            the event that calls this method
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress".equals(evt.getPropertyName())) {
			int progress = (Integer) evt.getNewValue();
			progressBar.setValue(progress);
			taskOutput.append(String.format("Completed %d%% of task.\n", task.getProgress()));
		}
	}

	/**
	 * Create the GUI and show it. As with all GUI code, this must run on the event-dispatching
	 * thread.
	 */
	private void createAndShowGUI() {
		JFrame frame = new JFrame("ProgressBarDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane = this;
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Schedule a job for the event-dispatching thread - creating and showing this application's
	 * GUI.
	 * 
	 * @param urlString
	 *            the string to download the file from
	 * @param fileName
	 *            the name of the downloaded file in the project
	 */
	public void downloadFile(final String urlString, final String fileName) {
		this.fileName = fileName;
		this.urlString = urlString;
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	/**
	 * Main task. Executed in background thread.
	 */
	class Task extends SwingWorker<Void, Void> {
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Void doInBackground() throws IOException {
			float progress = 0;
			setProgress(0);
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			long lengthURL = connection.getContentLengthLong();
			FileOutputStream outFile = new FileOutputStream(fileName);
			InputStream in = connection.getInputStream();
			byte[] b = new byte[1];
			long bytesRead = 0;
			while ((bytesRead = in.read(b)) != -1) {
				outFile.write(b);
				outFile.flush();
				progress += (float) bytesRead * 100 / lengthURL;

				setProgress((int) progress);
			}
			in.close();
			outFile.close();
			return null;
		}

		/**
		 * Executed in event dispatching thread.
		 */
		@Override
		public void done() {
			Toolkit.getDefaultToolkit().beep();
			startButton.setEnabled(true);
			setCursor(null);
			taskOutput.append("Done!\n");
		}
	}
}